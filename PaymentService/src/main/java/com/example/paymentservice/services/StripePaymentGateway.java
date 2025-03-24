package com.example.paymentservice.services;

import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.stereotype.Service;

@Service("stripePaymentGateway")
public class StripePaymentGateway implements PaymentService{
    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException, StripeException {
        //Make a call to Razorpay to generate the payment link.

        Stripe.apiKey = "sk_test_tR3PYbcVNZZ796tH88S4VQ2u";

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return "";
        //Not implemented fully as not able to create Stripe Account.
    }
}
