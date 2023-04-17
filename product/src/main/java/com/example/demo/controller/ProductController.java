package com.example.demo.controller;

import com.example.demo.dto.ProductDetailsDTO;
import com.example.demo.Api;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.ReviewServiceUnavailableException;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Api.V1+"/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @Operation(summary = "Gets product info by id: AdidasAPI integration and stats information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned info on found product" ),
            @ApiResponse(responseCode = "404", description = "Product not found by provided id  or Adidas API is unavailable",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Review service is unavailable",
                    content = @Content) })
    public ResponseEntity<ProductDetailsDTO> findOne(@PathVariable String id) throws ProductNotFoundException, ReviewServiceUnavailableException {
        return new ResponseEntity<>(productService.findOne(id), HttpStatus.OK);
    }
}
