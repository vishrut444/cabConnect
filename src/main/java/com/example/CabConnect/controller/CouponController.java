package com.example.CabConnect.controller;

import com.example.CabConnect.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    //API To add coupon
    @PostMapping
    public String addCoupon(@RequestParam("coupon-code")String couponCode,@RequestParam("percentageDiscount")int percentageDiscount){
        couponService.addCoupon(couponCode,percentageDiscount);
        return "Coupon Added Successfully!";
    }
}
