package com.bazarek.bazarek.function;

import java.util.Calendar;

public class Contract {

    public Calendar begin_date;
    public Calendar end_date;
    public Boolean enabled = true;

    /**
     * @param begin_date it's date of create contract.
     */
    public Contract(Calendar begin_date) {
        this.begin_date = begin_date;
        this.end_date = Calendar.getInstance();
        this.end_date.setTimeInMillis(this.begin_date.getTimeInMillis());
        this.end_date.add(Calendar.YEAR,2);
    }

    public static void setContractEnabledForCustomer(Integer customerId){
        Customer.foreach(Customer.getListCustomerById(Customer.allCustomer, customerId),
                new Foreach1<Customer>(){
                    @Override
                    public void call(Customer customer) {
                        customer.contract.enabled = true;
                    }
                });
    }

    public static void setContractDisabledForCustomer(Integer customerId){
        Customer.foreach(Customer.getListCustomerById(Customer.allCustomer, customerId),
                new Foreach1<Customer>() {
                    @Override
                    public void call(Customer customer) {
                        customer.contract.enabled = false;
                    }
                });
    }


}
