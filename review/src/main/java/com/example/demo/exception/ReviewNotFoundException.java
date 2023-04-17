package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewNotFoundException extends Exception {

  public ReviewNotFoundException() {
    super("error.review.not_found");
  }
}