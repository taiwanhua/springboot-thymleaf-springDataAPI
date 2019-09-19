package com.ahua.springdemo.web;

import com.ahua.springdemo.domain.Book;
import com.ahua.springdemo.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Bookscontrler {

  @Autowired private Bookservice bookservice;

  @GetMapping("/books1")
  public String getAll(Model model) {
    List<Book> all = bookservice.findALLddd();
    model.addAttribute("all1", all);
    //        這裡的return對應html檔
    return "books";
  }

  @GetMapping("/books/{id}")
  public String showone(@PathVariable long id, Model model) {
    Book book1 = bookservice.findonee(id);
    model.addAttribute("book2", book1);
    return "book";
  }

  @GetMapping("/books/input")
  public String input(Model model) {
    model.addAttribute("book2", new Book());
    // 家Model這列是因為修改與新增用同一個表單，修改要求傳入Model，然而新增沒有的話就會出錯
    return "input";
  }
  
  
  
    @PostMapping("/books")
    public String in(Book book,final RedirectAttributes redirectAttributes) {
      Book b=bookservice.savee(book);
      if (b!=null){
        redirectAttributes.addFlashAttribute("message",b.getName()+"提交成工");
        //只用這樣不成功顯示訊息，是因為共有兩次請求，事實上是POST裡的MODEL 希望在 GET取得，那這樣是不行的
        //Post---->redirect----->Get(books1)
      }
      return "redirect:/books1";
      // 會從新刷新books1內的方法
    }
/////---------------------展示錯誤的傳度值在兩個Requset之間START
//  @PostMapping("/books")
//  public String in(Book book,Model model) {
//    Book b=bookservice.savee(book);
//    if (b!=null){
//      model.addAttribute("message",b.getName()+"提交成工");
//      //只用這樣不成功顯示訊息，是因為共有兩次請求，事實上是POST裡的MODEL 希望在 GET取得，那這樣是不行的
//      //Post---->redirect----->Get(books1)
//    }
//    return "redirect:/books1";
//    // 會從新刷新books1內的方法
//  }
  /////---------------------展示錯誤的傳度值在兩個Requset之間END
  /** 修改所有書單內其中一筆，調用與新增同一頁面，但要先放值進去 */
  @GetMapping("/books/{id}/input")
  public String uodateone1(@PathVariable long id, Model model) {
    Book bookf = bookservice.findonee(id);
    model.addAttribute("book2", bookf);
    return "input";
  }
}
