package com.example.demo.controller;

import com.example.demo.Api;
import com.example.demo.dto.ReviewProductStat;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.exception.ReviewNotFoundException;
import com.example.demo.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping(Api.V1+"/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{product_id}")
    @Operation(summary = "Gets average score and total score stat info  by product id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned info on requested product", content= @Content(schema = @Schema(implementation = ReviewProductStat.class))),
    })
    public ResponseEntity<ReviewProductStat> retrieveStatByProductId(@PathVariable("product_id") @Parameter(name = "productId", description = "Product id", example = "B42000") String productId) {
        ReviewProductStat stat = reviewService.retrieveStatByProductId(productId);
        return new ResponseEntity<>(stat, HttpStatus.OK);
    }
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created review", content= @Content(schema = @Schema(implementation = Long.class))),
    })
    @Operation(summary = "Creates review")
    public ResponseEntity<Long> create(@RequestBody ReviewDTO reviewDTO){
        return new ResponseEntity<>(reviewService.create(reviewDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated score and comment if provided by review id"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "403", description = "Update operation failed due to illegal attempt to update someone else's data")
    })
    @Operation(summary = "Updates review by id")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,  @RequestBody ReviewDTO reviewDTO) throws ReviewNotFoundException, IllegalAccessException {
        reviewService.update(id, reviewDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted review by review id"),
            @ApiResponse(responseCode = "404", description = "Review not found"),
            @ApiResponse(responseCode = "403", description = "Delete operation failed due to illegal attempt to delete someone else's data")
    })
    @Operation(summary = "Deletes review by id")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) throws ReviewNotFoundException, IllegalAccessException, AuthenticationException {
        reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
