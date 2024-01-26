package com.platzi.javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateaway paymentGateaway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        PaymentGateaway paymentGateaway = Mockito.mock(PaymentGateaway.class);
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateaway);
    }

    @Test
    public void payment_is_correct() {

        Mockito.when(paymentGateaway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        boolean result = paymentProcessor.makePayment(1000);

        assertTrue(result);
    }

    @Test
    public void payment_is_wrong(){

        Mockito.when(paymentGateaway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        boolean result = paymentProcessor.makePayment(1000);
        assertFalse(result);
    }
}