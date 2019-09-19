package com.ahua.springdemo.domain;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String number;

  private String at;

  private String retest;

  public Book() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getAt() {
    return at;
  }

  public void setAt(String at) {
    this.at = at;
  }

  public String getRetest() {
    return retest;
  }

  public void setRetest(String retest) {
    this.retest = retest;
  }
}
