package com.ahua.springdemo.web;

import com.ahua.springdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping ("/api")
public class Hello {
    //    @Autowired()
    //    public Book book;
    //    @Value("${book.name}")
    //    public String b;
    //    @Value("${book.retest}")
    //    public String a;
    //@RequestMapping(value = "/say", method = RequestMethod.POST)
    //    @GetMapping("/say")
    //    public String hello() {
    //        return "helloworld idea";
    //    }
    //    @ResponseBody
    //    @GetMapping("/books")
    //    public Map getAll() {
    //        Map<String, Object> bookmap = new HashMap<>();
    //        bookmap.put("name", "anna");
    //        bookmap.put("age", 111);
    //        return bookmap;
    //    }
    //
    //@ResponseBody
    //    @GetMapping("/{id}/book/{text:[a-z_]+}")
    //    public Map one(@PathVariable("id") long id, @PathVariable("text") String text) {
    //        System.out.println("-------------id:" + id);
    //        Map<String, Object> bookmap = new HashMap<>();
    //        bookmap.put("name", "我是一本書");
    //        bookmap.put("number", "123156465451321");
    //        bookmap.put("a", "321");
    //        bookmap.put("a2", text);
    //        return bookmap;
    //    }
    //    @PostMapping("/book/post")
    //    public Map post(@RequestParam String name, @RequestParam String id, @RequestParam String ibsn) {
    //        Map<String, Object> bookmap = new HashMap<>();
    //        System.out.println("-------------name:" + name+"</br>-------------id:"+id+"</br>-------------ibsn:"+ibsn);
    //        bookmap.put("name",name);
    //        bookmap.put("id",id);
    //        bookmap.put("ibsn",ibsn);
    //        return bookmap;
    //    }

    @GetMapping ("/book")
    public void All (@RequestParam int size , @RequestParam (defaultValue = "0") int page) {
        //如同PathVariable若無指定名稱，那就得保證網址列傳入的參數等同這裡設定的參數名
        //        Map<String, Object> book1 = new HashMap<>();
        //        book1.put("name", "第一本");
        //        book1.put("id", "00001");
        //        book1.put("at", "王XX");
        //        Map<String, Object> book2 = new HashMap<>();
        //        book2.put("name", "第二本");
        //        book2.put("id", "00002");
        //        book2.put("at", "林XX");
        //        Map<String, Object> book3 = new HashMap<>();
        //        book3.put("name", "第三本");
        //        book3.put("id", "00003");
        //        book3.put("at", "陳XX");
        //        List<Map> booklist = new ArrayList<>();
        //        booklist.add(book1);
        //        booklist.add(book2);
        //        booklist.add(book3);
        //        System.out.println("-------------size:" + size);
        //return booklist.get(page);
        //return book;
    }
}
