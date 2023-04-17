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
  @org.springframework.web.bind.annotation.ExceptionHandler(ReviewNotFoundException.class)
  public ErrorInfo handleReviewNotFoundException(HttpServletRequest req, ReviewNotFoundException ex) {
    return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
  }
  @ResponseBody
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @org.springframework.web.bind.annotation.ExceptionHandler(IllegalAccessException.class)
  public ErrorInfo handlePhoneAlreadyReturnedException(HttpServletRequest req, IllegalAccessException ex) {
    return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
  }
}
