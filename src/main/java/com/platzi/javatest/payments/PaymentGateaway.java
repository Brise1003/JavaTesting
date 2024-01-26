package com.platzi.javatest.payments;

public interface PaymentGateaway {

    PaymentResponse requestPayment(PaymentRequest request);
}
