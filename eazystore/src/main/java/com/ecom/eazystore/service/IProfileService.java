package com.ecom.eazystore.service;

import com.ecom.eazystore.dto.ProfileRequestDto;
import com.ecom.eazystore.dto.ProfileResponseDto;

public interface IProfileService {

    ProfileResponseDto getProfile();

    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}