package com.bazarek.bazarek.function.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@ToString
@Slf4j
public class Customer {

    static public ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Contract contract;

    public Customer(Integer id, String name, String address, String state, String primaryContact, String domain, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.state = state;
        this.primaryContact = primaryContact;
        this.domain = domain;
        this.enabled = enabled;
    }

    public Customer() {
    }

    /**
     * Funkcja anonimowa w klasie.
     */
    private interface Function1<A1,B>{
        public B call(A1 in1);
    }

    /** Szuka obiektu po id. Może zwrócić NULL lub wyjatek NullPointerExeption!
     * @param customerId int id customer
     * @return customer by id if exist. Ij not exist return null.
     */
    public static Customer getCustomerById(Integer customerId){
        for (Customer customer: Customer.allCustomer){
            if (customer.id == customerId) {
                return customer;
            }
        }
        return null;
    }

    /** Zwraca LISTE, która może być pusta :)
     * @param customerId int id customer
     * @return list exist customer by id
     */
    public static ArrayList<Customer> getListCustomerById(Integer customerId){
        ArrayList<Customer> outList = new ArrayList<>();
        for (Customer customer : Customer.allCustomer) {
            if (customer.id == customerId){
                outList.add(customer);
            }
        }
        return outList;
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

    /**
     * Zmienne funkcyjne EnabledCustomer i DisabledCustomer. Zastosowanie zasady DRY
     */
    static final public Function1<Customer,Boolean> EnabledCustomer = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer customer) {
            return customer.enabled = true;
        }
    };

    static final public Function1<Customer,Boolean> DisabledCustomer = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer customer) {
            return customer.enabled = false;
        }
    };

}
