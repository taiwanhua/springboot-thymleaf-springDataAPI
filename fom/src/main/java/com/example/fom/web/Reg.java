package com.example.fom.web;

import com.example.fom.domain.Twopass;
import com.example.fom.domain.UseinterST;
import com.example.fom.domain.User;
import com.example.fom.domain.UserRepos;
import com.example.fom.error.Httpstatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Reg {
  @Autowired private UserRepos userRepos;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/reg")
  public String reg(Model model) {
    model.addAttribute("qtwopass", new Twopass());

    return "reg";
  }

  //  @PostMapping("/reg")
  //  public String regPost(Twopass twopass) {
  //    User user = new User();
  //    BeanUtils.copyProperties(twopass, user);  //經過這方法後上一行new出來的user，就被從twopass灌相同name的值進去了，
  //    userRepos.save(user);
  //    return "redirect:/login";
  //  }

  /// ###########################################將BeanUtils.copyProperties(twopass, user);封裝至方法
  //  @PostMapping("/reg")
  //  public String regPost(Twopass twopass) {
  //    User user = copyPer(twopass);
  //    userRepos.save(user);
  //    return "redirect:/login";
  //  }
  //
  //  private User copyPer(Twopass twopass) {
  //    User user = new User();
  //    BeanUtils.copyProperties(twopass, user);
  //    return user;
  //  }

  ///// #########################################以面向接口的方式泛型轉換類實現轉換實體類
  //  @PostMapping("/reg")
  //  public String regPost(Twopass twopass) {
  //    User user = new UseinterST().convert(twopass);
  //    userRepos.save(user);
  //    return "redirect:/login";
  //  }

  ///// ###############################再將轉換方法直接放到Twopass類中
  //  @PostMapping("/reg")
  //  public String regPost(Twopass twopass) {
  //    User user = twopass.conver();
  //    userRepos.save(user);
  //    return "redirect:/login";
  //  }
  /////////// ############################## 最後想把接接口類的UseinterST省略，直接在實體類Twopass接接口
  @PostMapping("/reg")
  public String regPost(
      @Valid @ModelAttribute("qtwopass") Twopass twopass,
      BindingResult bindingResult,
      Model module) {

    // module.addAttribute("qtwopass",twopass);
    Boolean r = true;
    if (!twopass.getUserpass().isBlank()) {
      if (!twopass.eu()) {
        bindingResult.rejectValue("checkuserpass", "errorcom", "密碼不相等");
        r = false;
      }
    }
    //    if (bindingResult.hasErrors()) {
    //      List<FieldError> f = bindingResult.getFieldErrors();
    //      for (FieldError error : f) {
    //        System.out.println(
    //            error.getField() + ":" + error.getDefaultMessage() + ":" + error.getCode());
    //      }
    //      r = false;
    //    }
    if (bindingResult.hasErrors()) {
      return "reg";
    }
    if (false == r) {
      //        module.addAttribute("mo",twopass);
      return "reg";
    }
    User user = twopass.conver();
    userRepos.save(user);
    return "redirect:/login";
  }

  @GetMapping("/find/{id}")
  public String findoneu(@PathVariable Long id, Model model) {
    User ui = userRepos.findById(id).orElse(null);
    if (ui == null) {
      throw new Httpstatus(
          "沒找到錯了錯了"); // 會在Log裡拋出異常，但是若沒有在繼承RuntimeException的類裡面重新導向Httpstatus的話，就不會導向重新
    }
    model.addAttribute("ui", ui);
    return "find";
  }

  //  private final Logger logger = LoggerFactory.getLogger(Reg.class);
  //
  //  @ExceptionHandler({Exception.class})//在同一類別裡加入異常攔截器，那只會針對本類別做處理
  //  public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception
  // {
  //    logger.error("Reques1t URL112 : sdfhdfg22{} , Exception e : {}", request.getRequestURI(),
  // e.getMessage());
  //    if (AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null){
  //      throw e;//提早拋出異常，讓框架自己處理
  //    }
  //    ModelAndView mav = new ModelAndView();//加載視圖
  //    mav.addObject("request", request.getRequestURI());
  //    mav.addObject("Message", e.getMessage());
  //    mav.setViewName("error/error"); //指定跳轉的頁面templates/error/error
  //    return mav;
  //  }

}
