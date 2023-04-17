package com.example.demo.service.impl;

import com.example.demo.dto.ProductDetailsDTO;
import com.example.demo.dto.ReviewProductStat;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.ReviewServiceUnavailableException;
import com.example.demo.model.AdidasProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private AdidasAPIService adidasAPIService;
    @Autowired
    private ReviewAPIService reviewAPIService;


    public ProductDetailsDTO findOne(String id) throws ProductNotFoundException, ReviewServiceUnavailableException {
        AdidasProductEntity adidasInfo = adidasAPIService.retrieveInfo(id);
        if(Objects.isNull(adidasInfo))
            throw new ProductNotFoundException();
        ReviewProductStat stat = reviewAPIService.retrieveInfo(id);
        if(Objects.isNull(stat))
            throw new ReviewServiceUnavailableException();
        return new ProductDetailsDTO(adidasInfo, stat);
    }
}