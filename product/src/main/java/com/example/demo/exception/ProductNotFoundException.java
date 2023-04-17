package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductNotFoundException extends Exception {

  public ProductNotFoundException() {
    super("error.phone.not_found");
  }
}