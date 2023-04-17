package com.example.demo.repository;

import com.example.demo.dto.ReviewProductStat;
import com.example.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT new com.example.demo.dto.ReviewProductStat(r.productId, AVG(r.score), COUNT(r.productId)) FROM Review r WHERE r.productId = :productId GROUP BY r.productId")
    ReviewProductStat statByProductId(@Param("productId") String productId);
}
