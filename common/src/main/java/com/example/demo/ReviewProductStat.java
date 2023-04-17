package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ReviewProductStat implements Serializable {
    private String productId;
    private Double avgScore;
    private Long rvCount;
    public ReviewProductStat(String productId, Double avgScore, Long rvCount){
        this.productId = productId;
        this.avgScore = avgScore;
        this.rvCount = rvCount;
    }
}
