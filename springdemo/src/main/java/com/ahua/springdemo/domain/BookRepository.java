package com.ahua.springdemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //數據操作層

    /**
     * 定義已name查詢
     */
    List<Book> findByName(String name);

    List<Book> findByNameAndAndIdBetween(String name, long min, long max);

    List<Book> findByNameContains(String name);

    //@Query("select b from Book b where length(b.number)>?1 ")
    @Query(value = "select * from book  where length(number)>?1 ", nativeQuery = true)
    List<Book> findByJPQL(int i);


    @Transactional()
    @Modifying
    @Query("delete from Book b where id=?1")
    int DelbyJPQL(long id);


    @Transactional()
    @Modifying
    @Query("update Book b set b.name = ?1  where at=?2")
    int updatebyJPQL(String name, String at);
    //delete也要加這種註釋，return的int 為修改了幾筆
    //若再接口層與服務層同時定義Transactional屬性，則服務層會覆蓋接口層
    //若在服務層把多個方法包進一個事務裡，有加上Transactional時若有錯誤則操作會復原，若沒加執行過的操作將不會復原
}
