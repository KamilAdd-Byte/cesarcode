package com.bazarek.bazarek.wallet.model;

import java.util.Map;
import java.util.TreeMap;

public class ProductsMapBase {
   Map<String,Product>products = new TreeMap<>();

   public Map<String,Product> products (){
       products.put("Wsaq-244321",new Product(1,"Fasolka",4.67));
       products.put("Sony-5q1",new Product(2,"Telewizor",2800.99));
       products.put("Aewq-7765",new Product(3,"Fasolka",4.67));
       products.put("PrrQ-4264",new Product(4,"Fasolka",4.67));
       return products;
   }

   public void addProduct(String key, Product product){
       products.put(key, product);
   }

   public void removeProduct(Product product){
       products.remove(product);
   }
}
