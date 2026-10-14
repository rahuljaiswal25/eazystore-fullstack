package com.ecom.eazystore.dto;

public record PaymentIntentRequestDto(Long amount, String currency) {
}