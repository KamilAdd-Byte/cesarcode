package com.bazarek.bazarek.lambdas;

import com.bazarek.bazarek.lambdas.inte.FunctionCompare;
import com.bazarek.bazarek.lambdas.inte.FunctionCompleteName;
import com.bazarek.bazarek.model.User;
import lombok.extern.slf4j.Slf4j;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

@Slf4j
public class LambdasExample {


    public static void main(String[] args) {
        FunctionCompleteName functionCompleteName = new FunctionCompleteName();
        BinaryOperator<Integer> add = Integer::sum;
        Integer apply = add.apply(4, 8);
        log.info("Number {}",apply);

        Predicate<Integer> isSixNumber = (x) -> x < 6;
        boolean test = isSixNumber.test(8);
        log.info("Predicate number is six {}",test);

        char[] name = functionCompleteName.apply("Sulejewski");
        log.warn("Char[] for name {}", name);
    }
}
