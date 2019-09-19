package com.example.fom.domain;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UseinterST implements InterST<Twopass, Object> {

  ///// ############寫到實體類Twopass後就省略
  //  @Override
  //  public User convert(Twopass twopass) {
  //    User user = new User();
  //    BeanUtils.copyProperties(twopass, user);
  //    return user;
  //  }
  @Override
  public User convert(Twopass twopass) {
    return null;
  }

}
