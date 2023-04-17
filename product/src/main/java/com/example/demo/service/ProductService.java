package com.example.demo.service;

import com.example.demo.dto.ProductDetailsDTO;
import com.example.demo.exception.*;

public interface ProductService {
    ProductDetailsDTO findOne(String id) throws ProductNotFoundException, ReviewServiceUnavailableException;
}
