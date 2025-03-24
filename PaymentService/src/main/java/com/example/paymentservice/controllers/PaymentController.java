package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.GeneratePaymentLinkRequestDto;
import com.example.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(@Qualifier("stripePaymentGateway") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto requestDto) throws RazorpayException {
        //Ideally we should handle the exception in the Controller using Controller Advice.
        return paymentService.generatePaymentLink(requestDto.getOrderId());
    }

    public void handleWebhookEvent(){

    }
}
