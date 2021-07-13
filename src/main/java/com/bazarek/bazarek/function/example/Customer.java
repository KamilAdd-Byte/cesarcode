package com.bazarek.bazarek.function.example;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    static public ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;

    //pusty konstruktor
    public Customer() {
    }
    /**
     * Funkcja anonimowa.
     */
    private interface Function1<A1,B>{
        public B call(A1 in1);
    }

    public static List<String> getEnabledCustomerAddress() {
        return Customer.getEnabledCustomerField(new Function1<Customer,String>() {
            public String call(Customer customer) {
                return customer.address;
            }
        });
    }

    public static List<String> getEnabledCustomerNames() {
        return Customer.getEnabledCustomerField(new Function1<Customer,String>(){
            @Override
            public String call(Customer customer) {
                return customer.name;
            }
        });
    }
    public static List<String> getEnabledCustomerState() {
        return Customer.getEnabledCustomerField(new Function1<Customer,String>(){
            @Override
            public String call(Customer customer) {
                return customer.state;
            }
        });
    }
    public static List<String> getEnabledCustomerPrimaryContacts() {
        return Customer.getEnabledCustomerField(new Function1<Customer,String>(){
            @Override
            public String call(Customer customer) {
                return customer.primaryContact;
            }
        });
    }

    public static List<String> getEnabledCustomerDomains() {
        return Customer.getEnabledCustomerField(new Function1<Customer,String>(){
            @Override
            public String call(Customer customer) {
                return customer.domain;
            }
        });
    }

    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func) {
        ArrayList<B> outList = new ArrayList<B>();
        for (Customer customer : Customer.allCustomer) {
            if (customer.enabled){
                outList.add(func.call(customer));
            }
        }
        return outList;
    }
    /**
     * Domknięcia (ang. closures) są bardzo podobne do funkcji lambda, tyle że
     * odwołują się do zmiennych spoza zakresu funkcji. Mówiąc najprościej: ciało
     * funkcji odwołuje się do zmiennej, która nie istnieje ani w ciele, ani w liście
     * parametrów.
     */

    public static List<String> getEnabledCustomerBossesEmail() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            @Override
            public String call(Customer customer) {
                return "szef@" + customer.domain;
            }
        });
    }

    public static List<String> getEnabledCustomerSomeoneEmail(final String someone){
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            @Override
            public String call(Customer customer) {
                return someone + "@" + customer.domain;
            }
        });
    }

    /**
     * Naruszenie zasady DRY w metodzie disabled:
     */
    public static <B> List<B> getDisabledCustomerField(Function1<Customer,B> func){
        ArrayList<B> outList = new ArrayList<B>();
        for (Customer customer: Customer.allCustomer){
            if (!customer.enabled){
                outList.add(func.call(customer));
            }
        }
        return outList;
    }

    /**
     * Metoda getField z funkcją testującą
     */

    public static <B> List<B> getField(Function1<Customer,Boolean> test, Function1<Customer,B> func){
        ArrayList<B> outList = new ArrayList<B>();
        for (Customer customer: Customer.allCustomer){
            if (test.call(customer)){
                outList.add(func.call(customer));
            }
        }
        return outList;
    }
    //TODO strona 37 Programowanie funkcyjne
}
