package com.example.fom.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Twopass {
  @NotBlank private String username;

  @Length(min = 6, message = "至少6個字，智障")
  @NotBlank
  private String userpass;

  @NotBlank private String checkuserpass;

  @Pattern(regexp = "[\\d]{10}", message = "要符合啦智障")
  private String phone;

  @Email private String email;

  public Twopass() {}

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserpass() {
    return userpass;
  }

  public void setUserpass(String userpass) {
    this.userpass = userpass;
  }

  public String getCheckuserpass() {
    return checkuserpass;
  }

  public void setCheckuserpass(String checkuserpass) {
    this.checkuserpass = checkuserpass;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User conver() {
    User user = new UseinterST().convert(this);
    return user;
  }

  private class UseinterST implements InterST<Twopass, User> {

    @Override
    public User convert(Twopass twopass) {
      User user = new User();
      BeanUtils.copyProperties(twopass, user);
      return user;
    }
  }

  public Boolean eu() {
    return (this.getUserpass()).equals(this.getCheckuserpass());
  }
}
