package com.example.boottest.service;

import com.example.boottest.domin.Book;
import com.example.boottest.domin.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Bookservice {
  // Service層
  @Autowired private BookRepository bookRepository;

  public List<Book> findall() {
    return bookRepository.findAll();
  }
  public Book saveone(Book book){
      return bookRepository.save(book);
  }
  ////////////////////////必須提供查詢修改的那筆資料
    public Book findone(Long i){
      return bookRepository.findById(i).orElse(null);
    }
    ///////////////////分頁
    public Page<Book> findbypage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
