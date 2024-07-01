package com.example.CabConnect.service;

import com.example.CabConnect.Converter.BookingConverter;
import com.example.CabConnect.dto.request.BookingRequest;
import com.example.CabConnect.dto.response.BookingResponse;
import com.example.CabConnect.exception.CabNotAvailableException;
import com.example.CabConnect.exception.CustomerNotFoundException;
import com.example.CabConnect.model.*;
import com.example.CabConnect.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    //bean for sending the e-mail to client
    @Autowired
    JavaMailSender javaMailSender;

    //Field Injection it is not good way
//    @Autowired
//    BookingRepository bookingRepository;
//    @Autowired
//    CabRepository cabRepository;
//    @Autowired
//    CustomerRepository customerRepository;
//    @Autowired
//    DriverRepository driverRepository;

    //Constructor Injection
    private final BookingRepository bookingRepository;
    private final CabRepository cabRepository;
    private final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final CouponRepository couponRepository;

    //This is done at backend jus write @RequireArgsConstructor
//    public BookingService(BookingRepository bookingRepository,
//                          CabRepository cabRepository,
//                          CustomerRepository customerRepository,
//                          DriverRepository driverRepository) {
//        this.bookingRepository = bookingRepository;
//        this.cabRepository = cabRepository;
//        this.customerRepository = customerRepository;
//        this.driverRepository = driverRepository;
//    }

    public BookingResponse bookCab(BookingRequest bookingRequest,boolean couponApplied) {

        //1) verify that customer is valid or not
        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
        if (ObjectUtils.isEmpty(customer)) {//check if customer is null or not
            throw new CustomerNotFoundException("Invalid e-mail Id!");
        }

        //2) check if cab is available we will get random cab using sql
        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if (optionalCab.isEmpty()) {
            throw new CabNotAvailableException("Seems that all the Driver's are busy at the moment!");
        }
        Cab cab = optionalCab.get();
        cab.setBooked(true);//to make booking from 0 -> 1 in cab table in DB
        Driver driver = cab.getDriver();

        //3) now we have our cab and the customer now we have to book
        //booking entity
        //it doesn't have PK right now, so we first save it to generate PK
        //and if we perform 5) without saving it, it will save Booking twice
        Booking booking = BookingConverter.bookingRequestToBooking(bookingRequest, cab);

        //checking for coupon applied
        Optional<Coupon> optionalCoupon = couponRepository.getRandomAvailableCoupon();
        double discount = 1;
        if(optionalCoupon.isPresent()){
            Coupon coupon = optionalCoupon.get();
            coupon.setApplicable(false);
            discount *= (double) (100 - coupon.getPercentageDiscount()) /100;
        }
        
        //saving booking
        booking.setCustomer(customer);
        booking.setDriver(driver);
        booking.setTotalFare(booking.getTotalFare()*discount);
        Booking savedBooking = bookingRepository.save(booking);//no it will have PK

        //4) check for entity classes involved if there is something to set
        //entity's: customer, cab, booking, driver is indirectly involved

        customer.getBookings().add(savedBooking);//adding booking for the customer list
        driver.getBookings().add(savedBooking);
        //first save the booking
        //booking.setCustomer(customer);
        //booking.setDriver(driver);


        //5) now saving customer, driver and booking
        //if we save driver Booking will be saved as it is Cascade relationship
        customerRepository.save(customer);//saves customer + savedBooking
        driverRepository.save(driver);//saves driver + savedBooking

        //6) sending e-mail before preparing response (Optional Step)
        sendEmail(savedBooking);

        //7) prepare response -> dto
        return BookingConverter.bookingToBookingResponse(savedBooking);
    }

    private void sendEmail(Booking savedBooking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("springtest444@gmail.com");
        simpleMailMessage.setTo(savedBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Your Ride Has Been Confirmed!");
        simpleMailMessage.setText("Congrats! "+savedBooking.getCustomer().getName()+
                " You ride is confirmed! Your Booking Id is: "+savedBooking.getBookingId()
        +" Driver details Driver name: "+savedBooking.getDriver().getName()+
                "Driver Mob No: "+savedBooking.getDriver().getMobileNo()+
                "Cab No: "+savedBooking.getDriver().getCab().getCabNumber()+
                "Total Fare: "+savedBooking.getTotalFare());
        javaMailSender.send(simpleMailMessage);//send email
    }
}
