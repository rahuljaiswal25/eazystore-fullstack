package com.ecom.eazystore.service;

import com.ecom.eazystore.dto.ProductDto;
import com.ecom.eazystore.entity.Product;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts();
}
