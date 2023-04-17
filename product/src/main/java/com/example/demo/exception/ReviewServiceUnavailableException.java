package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewServiceUnavailableException extends Exception {

  public ReviewServiceUnavailableException() {
    super("error.reviewservice.unavailable");
  }
}