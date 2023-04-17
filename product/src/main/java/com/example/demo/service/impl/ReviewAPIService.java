package com.example.demo.service.impl;

import com.example.demo.dto.ReviewProductStat;
import com.example.demo.model.AdidasProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ReviewAPIService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${review.api.base_url}")
    private String adidasAPIBaseUrl;
    private final static String ADIDAS_API_SEARCH_PRODUCT = "/api/v1/review/";
    public ReviewProductStat retrieveInfo(String id){
        ReviewProductStat res = null;
        try{
            String url = adidasAPIBaseUrl+ADIDAS_API_SEARCH_PRODUCT+id;
            ResponseEntity<ReviewProductStat> prodResponse = restTemplate.getForEntity(url, ReviewProductStat.class);
            switch (prodResponse.getStatusCode()){
                case OK:
                    res = prodResponse.getBody();
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            return res;
        }
        return res;
    }
}
