package com.bazarek.bazarek.wallet.model;

import com.bazarek.bazarek.cezar.CesarCode;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleConsumer;

public class Test {
    public static void main(String[] args) {
        CesarCode code = new CesarCode();
        ProductsMapBase productsMapBase = new ProductsMapBase();
        Map<String, Product> products = productsMapBase.products();
        Wallet wallet = new Wallet();

        Set<Map.Entry<String, Product>> entries = products.entrySet();
        entries.forEach(System.out::println);


        DoubleConsumer addMoney = wallet::addMoney;
        addMoney.accept(2900);
        System.out.println(wallet);

        WalletRepositories wr = new WalletRepositories() {
            @Override
            public void buy(Product product) {
                wallet.buy(product.getPrice());
            }
        };

        Collection<Product> values = products.values();
        for (Product value : values) {
            System.out.println(value);
        }
        Set<String> keySet = products.keySet();
        System.out.println(keySet);

        wr.buy(products.get("Sony-5q1"));
        wr.buy(products.get("PrrQ-4264"));

        values.forEach(System.out::println);
    }
}
