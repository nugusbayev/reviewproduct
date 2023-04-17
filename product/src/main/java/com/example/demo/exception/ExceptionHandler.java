package com.example.demo.exception;

import com.example.demo.ErrorInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {

  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
  public ErrorInfo handleProductNotFoundException(HttpServletRequest req, ProductNotFoundException ex) {
    return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
  }
  @ResponseBody
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @org.springframework.web.bind.annotation.ExceptionHandler(ReviewServiceUnavailableException.class)
  public ErrorInfo handleReviewServiceUnavailableException(HttpServletRequest req, ReviewServiceUnavailableException ex) {
    return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
  }
}
