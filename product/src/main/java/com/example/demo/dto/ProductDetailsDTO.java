package com.example.demo.dto;

import com.example.demo.model.AdidasProductEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductDetailsDTO {
    private AdidasProductEntity adidasInfo;
    private com.example.demo.dto.ReviewProductStat statInfo;
    public ProductDetailsDTO(AdidasProductEntity adidasInfo, com.example.demo.dto.ReviewProductStat statInfo){
        this.adidasInfo =adidasInfo;
        this.statInfo = statInfo;

    }
}
