package com.example.demo.service.impl;

import com.example.demo.model.AdidasProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AdidasAPIService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${adidas.api.base_url}")
    private String adidasAPIBaseUrl;
    private final static String ADIDAS_API_SEARCH_PRODUCT = "/api/products/";
    public AdidasProductEntity retrieveInfo(String id){
        AdidasProductEntity res = null;
        try{
            String url = adidasAPIBaseUrl+ADIDAS_API_SEARCH_PRODUCT+id;
            //SSL certificate import needed, and adidas api is not allowed for crawlers and resttempplate, only for browsers, but this is demo so stub is provided
//            ResponseEntity<AdidasProductEntity> prodResponse = restTemplate.getForEntity(url, AdidasProductEntity.class);
//            switch (prodResponse.getStatusCode()){
//                case OK:
//                    res = prodResponse.getBody();
//                    break;
//                default:
//                    break;
//            }
            res = new AdidasProductEntity();
            res.setColor("black");
            res.setId(id);
            res.setGender("M");
            res.setPrice("20000");
        }
        catch (Exception e){
            return res;
        }
        return res;
    }
}
