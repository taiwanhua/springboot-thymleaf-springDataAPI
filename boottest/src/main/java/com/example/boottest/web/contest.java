package com.example.boottest.web;

import com.example.boottest.domin.Book;
import com.example.boottest.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class contest {
  // Web層
  @Autowired private Bookservice bookservice;

  @GetMapping("/thy")
  public String s(Model model) {
    List<Book> g = bookservice.findall();
    model.addAttribute("c", g);
    return "thymeleaftest";
  }

  @GetMapping("/newone") // ////////因為下方修改用的html都是newone.html，但修改的需要傳入Model，而原本新增的沒有會出錯，所以給一個空Model
  public String newo(Model model) {
    Book b = new Book();
    model.addAttribute("c", b);
    return "newone";
  }

  @PostMapping("/new")
  public String n(
      Book book,
      RedirectAttributes
          redirectAttributes) { // 當from表單的input標籤下name欄位都對應到Book實體類時，會自動傳入實體類Book讓我們在java端取到值
    Book b = bookservice.saveone(book);
    if (null != b.getId()) {
      redirectAttributes.addFlashAttribute("massge", "第" + b.getId() + "筆提交成功");
    }
    return "redirect:/thy"; // 重定向到上面/thy的GET Request
  }
  //// 當想做修改時，希望把值代入到修改的模板(同新增模板)裡必須先查詢並放入Model
  @GetMapping("/modify/{id}")
  public String modify(@PathVariable Long id, Model model) {
    Book book = bookservice.findone(id);
    model.addAttribute("c", book);
    return "newone";
  }

  /////////////////////////////////
  //    @GetMapping("/page")
  //    public String page(@RequestParam(defaultValue ="0") int page ,@RequestParam(defaultValue =
  // "5") int size,Model model){
  //      Pageable pageable=PageRequest.of(page,size,Sort.by("id").ascending());
  //      Page<Book> c=bookservice.findbypage(pageable);
  //      model.addAttribute("g",c);
  //
  //      return "page";
  //    }

  @GetMapping("/page")
  public String page(
      @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
      Model model) {

    Page<Book> c = bookservice.findbypage(pageable);
    model.addAttribute("g", c);

    return "page";
  }
}
