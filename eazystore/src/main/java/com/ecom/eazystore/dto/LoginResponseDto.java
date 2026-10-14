package com.ecom.eazystore.dto;

public record LoginResponseDto(String message, UserDto user, String jwtToken) {
}