package com.example.fom.domain;

public interface InterST<S,T> {
    ///S是傳入的對象，T轉出的對象
    T convert(S s);

     default T convert1(S s, Long i) {////default 使得接口類內可以存在不須覆寫之方法
        return null;
    }
}
