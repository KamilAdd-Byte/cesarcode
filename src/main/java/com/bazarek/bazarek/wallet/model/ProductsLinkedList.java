package com.bazarek.bazarek.wallet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.stream.Stream;

@ToString
@Getter
@Setter
public class ProductsLinkedList {
    LinkedList<Product> myProduct = new LinkedList<>();

    public LinkedList<Product> myProduct () {
        myProduct.add(new Product(1,"Oscypek",3.54));
        myProduct.add(new Product(2,"Kabanosy",7.99));
        myProduct.add(new Product(3,"Babka - Łaciata",11.00));
        return myProduct;
    }

    public void removeFirstProduct(){
        myProduct.removeFirst();
    }


}
