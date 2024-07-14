package com.example.nagoyameshi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nagoyameshi.service.StripeService;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;

@RestController
@RequestMapping("/api/checkout")
public class StripeWebhookController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/create-session")
    public Map<String, String> createCheckoutSession(@RequestParam String planName, @RequestParam long amount) {
        Map<String, String> response = new HashMap<>();
        String sessionUrl = stripeService.createCheckoutSession(planName, amount);
		response.put("sessionUrl", sessionUrl);
        return response;
    }

    @RestController
    @RequestMapping("/webhook")
    public class WebhookController {

        @PostMapping
        public void handleStripeWebhook(@RequestBody Event event) {
            if ("checkout.session.completed".equals(event.getType())) {
                Session session = (Session) event.getDataObjectDeserializer().getObject().get();
                // session情報を使ってDBを更新します
                // 例: userId, planId, 支払い成功のフラグなど
            }
        }
    }
}