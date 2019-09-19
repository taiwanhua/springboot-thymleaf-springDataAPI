package com.example.boottest.domin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
  // 實體類
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  String name;
  String at;
  String sex;

  public Book() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAt() {
    return at;
  }

  public void setAt(String at) {
    this.at = at;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
