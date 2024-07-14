//package com.example.nagoyameshi.controller;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.nagoyameshi.service.StripeService;
//import com.stripe.exception.StripeException;
//
//@RestController
//@RequestMapping("/api/checkout")
//public class SubscriptionController {
//
//    @Autowired
//    private StripeService stripeService;
//
//    @PostMapping("/create-session")
//    public Map<String, String> createCheckoutSession(@RequestParam String planName, @RequestParam long amount) throws StripeException {
//        Map<String, String> response = new HashMap<>();
//        String sessionUrl = stripeService.createCheckoutSession(planName, amount);
//		response.put("sessionUrl", sessionUrl);
//        return response;
//    }
//}
