package com.ecom.eazystore.service;

import com.ecom.eazystore.dto.ContactRequestDto;
import com.ecom.eazystore.dto.ContactResponseDto;
import com.ecom.eazystore.dto.ProductDto;

import java.util.List;

public interface IContactService {

    boolean saveContact(ContactRequestDto contactRequestDto);

    List<ContactResponseDto> getAllOpenMessages();

    void updateMessageStatus(Long contactId, String status);
}