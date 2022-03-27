package com.bazarek.bazarek.lambdas.inte;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FunctionCompleteName implements FunctionCompare<String,char[]>{
    @Override
    public char[] apply(String u) {
        log.warn("Char[] for name {}", u);
        return u.toUpperCase().toCharArray();
    }
}
