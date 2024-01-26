package com.platzi.javatest.payments;

public class PaymentProcessor {

    private PaymentGateaway paymentGateaway;

    public PaymentProcessor(PaymentGateaway paymentGateaway) {
        this.paymentGateaway = paymentGateaway;
    }

    public boolean makePayment(double amount){

        PaymentResponse response = paymentGateaway.requestPayment(new PaymentRequest(amount));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        } else return false;

    }
}
