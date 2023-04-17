package com.example.demo.service;

import com.example.demo.dto.ReviewProductStat;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.exception.*;

public interface ReviewService {

    Long create(ReviewDTO review);

    void update(Long id, ReviewDTO reviewDTO) throws ReviewNotFoundException, IllegalAccessException;

    void delete(Long id) throws ReviewNotFoundException, IllegalAccessException;

    ReviewProductStat retrieveStatByProductId(String productId);
}
