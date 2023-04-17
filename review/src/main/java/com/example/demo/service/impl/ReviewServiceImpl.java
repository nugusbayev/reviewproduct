package com.example.demo.service.impl;

import com.example.demo.dto.ReviewProductStat;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Review;
import com.example.demo.exception.ReviewNotFoundException;
import com.example.demo.model.CurrentUser;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CurrentUser currentUser;
    @Override
    @CacheEvict(value = "REVIEW", key = "#reviewDTO.productId")
    public Long create(ReviewDTO reviewDTO) {
        Review review = Review.fromDTO(reviewDTO);
        reviewRepository.save(review);
        return review.getId();
    }

    @Override
    public void update(Long id, ReviewDTO reviewDTO) throws ReviewNotFoundException, IllegalAccessException {
        Review review = reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new);
        if(!review.getAuthorId().equals(currentUser.getId()))
            throw new IllegalAccessException("error.auth.only_author_can_update_review");
        review.setReviewedAt(LocalDateTime.now());
        review.setScore(reviewDTO.getScore());
        review.setComment(reviewDTO.getComment());
        reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) throws ReviewNotFoundException, IllegalAccessException {
        Review review = reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new);
        if(!review.getAuthorId().equals(currentUser.getId()))
            throw new IllegalAccessException("error.auth.only_author_can_delete_review");
        removeTotally(review.getProductId(), id);
    }
    @CacheEvict(value = "REVIEW", key = "#productId")
    public void removeTotally(String productId, Long id){
        reviewRepository.deleteById(id);
    }


    @Override
    @Cacheable(value = "REVIEW", key = "#productId")
    public ReviewProductStat retrieveStatByProductId(String productId) {
        ReviewProductStat stat =  reviewRepository.statByProductId(productId);
        return stat;
    }
}