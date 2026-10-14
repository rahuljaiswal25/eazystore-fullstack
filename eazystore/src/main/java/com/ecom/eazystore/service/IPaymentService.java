package com.ecom.eazystore.service;

import com.ecom.eazystore.dto.PaymentIntentRequestDto;
import com.ecom.eazystore.dto.PaymentIntentResponseDto;

public interface IPaymentService {

    PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto requestDto);
}