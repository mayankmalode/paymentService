package com.example.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentGateway")
public class RazorpayPaymentGateway implements PaymentService{
    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {
        //Make a call to Razorpay to generate the payment link.

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);  //10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 10/*min*/ * 60/*sec*/ *1000 /*milli sec*/);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for a chocolate");
        JSONObject customer = new JSONObject();

        //Call the OrderService to get the Order details.
        //Order order = restTemplate.getForObject("orderService URL", Order.class);

        customer.put("name","Mayank Malode");
        customer.put("contact","+919921823989");
        customer.put("email","mayankamalode@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
//        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://amazon.com/"); //https://example-callback-url.com/
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
