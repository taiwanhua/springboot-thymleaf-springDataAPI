package com.ahua.springdemo.service;

import com.ahua.springdemo.domain.Book;
import com.ahua.springdemo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Bookservice {

  // Service層
  @Autowired private BookRepository bookRepository;

  /*
   * 返回全部
   * */
  public List<Book> findALLddd() {
    return bookRepository.findAll();
  }

  /*
  插入一個
  * */
  public Book savee(Book book) {
    return bookRepository.save(book);
  }

  /*
   * 查一個
   * */
  public Book findonee(long id) {
    return bookRepository.findById(id).orElse(null);
  }

  /*
   * 更新一個
   * */
  public Book updateonee(Book book) {
    return bookRepository.save(book);
  }

  public void deleteonee(long id) {
    bookRepository.deleteById(id);
  }

  /////// 複雜查詢
  public List<Book> findbynamee(String name) {
    return bookRepository.findByName(name);
  }

  public List<Book> findbynameebet(String name, long min, long max) {
    return bookRepository.findByNameAndAndIdBetween(name, min, max);
  }

  public List<Book> findbynameelike(String name) {
    return bookRepository.findByNameContains(name);
  }

  public List<Book> findbyJPQL(int i) {
    return bookRepository.findByJPQL(i);
  }

  public int upbyJPQL(String name, String at) {
    return bookRepository.updatebyJPQL(name, at);
  }

  public int DELbyJPQL(long id) {
    return bookRepository.DelbyJPQL(id);
  }

  /** 使用JPA事務 */


  public int trandelandupdate(long id, String name, String at) {
    int del = bookRepository.DelbyJPQL(id);
    int up = bookRepository.updatebyJPQL(name, at);
    return up + del;
  }
}
