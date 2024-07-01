package com.example.CabConnect.service;

import com.example.CabConnect.model.Coupon;
import com.example.CabConnect.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public void addCoupon(String couponCode, int percentageDiscount) {
        Coupon coupon = new Coupon();
        coupon.setCouponCode(couponCode);
        coupon.setPercentageDiscount(percentageDiscount);
        coupon.setApplicable(true);
        couponRepository.save(coupon);
    }
}
