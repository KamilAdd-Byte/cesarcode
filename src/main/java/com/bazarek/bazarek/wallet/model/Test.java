package com.bazarek.bazarek.wallet.model;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        double money = wallet.addMoney(50.00);
        System.out.println(wallet);

        wallet.buy(41);
        wallet.addMoney(30.00);

        System.out.println(wallet);



        ProductsLinkedList pl = new ProductsLinkedList();
        LinkedList<Product> products = pl.myProduct();
        for (Product product : products) {
            System.out.println(product);
        }

        pl.removeFirstProduct();

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
