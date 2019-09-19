package com.ahua.springdemo.web;

import com.ahua.springdemo.domain.Book;
import com.ahua.springdemo.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/ap1/v1", method = RequestMethod.GET)
public class BookCtrl {

  // WEB層
  @Autowired private Bookservice bookservice; // 注入

  /**
   * 取得資料庫列表
   *
   * @return
   */
  @GetMapping("/book")
  public List<Book> getAll() {
    return bookservice.findALLddd();
  }


  @GetMapping("/testbook") // 除錯
  public List<Book> testbook() {
    return bookservice.findALLddd();
  }


  @GetMapping("/test")
  public String test() {
    return "OK";
  }

  @PostMapping("/book")
  public Book savee(
      @RequestParam String at,
      @RequestParam String name,
      @RequestParam String number,
      @RequestParam String retest) {
    Book book = new Book();
    book.setAt(at);
    book.setName(name);
    book.setNumber(number);
    book.setRetest(retest);
    return bookservice.savee(book);
  }

  @GetMapping("/book/{id}")
  public Book findone(@PathVariable long id) {
    return bookservice.findonee(id);
  }

  @PutMapping("/book")
  public Book updateone(Book book) {
    return bookservice.updateonee(book);
  }
  //    @PutMapping("/book")
  //    public Book updateone(@RequestParam long id, @RequestParam String at, @RequestParam String
  // name, @RequestParam String number, @RequestParam String retest) {
  //        Book book = new Book();
  //        book.setId(id);
  //        book.setAt(at);
  //        book.setName(name);
  //        book.setNumber(number);
  //        book.setRetest(retest);
  //        return bookservice.updateonee(book);
  //    }

  @DeleteMapping("/book/{id}")
  public void del(@PathVariable long id) {
    bookservice.deleteonee(id);
  }

  ///////// 複雜查詢
  @PostMapping("/book/f")
  public List<Book> findbyname(@RequestParam String name) {
    return bookservice.findbynamee(name);
  }

  @PostMapping("/book/fb")
  public List<Book> findbynamebe(
      @RequestParam String name, @RequestParam long min, @RequestParam long max) {
    return bookservice.findbynameebet(name, min, max);
  }

  @PostMapping("/book/fl")
  public List<Book> findbynamebe(@RequestParam String name) {
    return bookservice.findbynameelike(name);
  }

  @PostMapping("/book/fj")
  public List<Book> findbyjpql(@RequestParam int i) {
    return bookservice.findbyJPQL(i);
  }

  @PostMapping("/book/uj")
  public int uppbyjpql(@RequestParam String at, @RequestParam String name) {
    return bookservice.upbyJPQL(name, at);
  }

  @PostMapping("/book/dj")
  public int dellbyjpql(@RequestParam long id) {
    return bookservice.DELbyJPQL(id);
  }

  @PostMapping("/book/duj")
  public int delupdate(@RequestParam long id, @RequestParam String at, @RequestParam String name) {
    return bookservice.trandelandupdate(id, name, at);
  }
}
