package com.example.fom.controllerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@ControllerAdvice//加入此標註後，所有外部控制器都會先經過這裡
public class Exceptionhandler {

  private final Logger logger = LoggerFactory.getLogger(Exceptionhandler.class);

  @ExceptionHandler({Exception.class})//異常攔截器
  public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
    logger.error(
        "Reques1t URL112 : sdfhdfg22{} , Exception e : {}",
        request.getRequestURI(),
        e.getMessage());
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      throw e;
    }
    ModelAndView mav = new ModelAndView(); // 加載視圖
    mav.addObject("request", request.getRequestURI());
    mav.addObject("Message", e.getMessage());
    mav.addObject("exception",e);
    mav.setViewName("error/error"); // 指定跳轉的頁面templates/error/error
    return mav;
  }
}
