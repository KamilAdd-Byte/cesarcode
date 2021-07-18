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

    private Calendar getBegin_date() {
        return begin_date;
    }

    private Contract setBegin_date(Calendar begin_date) {
        this.begin_date = begin_date;
        return this;
    }

    private Calendar getEnd_date() {
        return end_date;
    }

    private Contract setEnd_date(Calendar end_date) {
        this.end_date = end_date;
        return this;
    }

    private Boolean getEnabled() {
        return enabled;
    }

    private Contract setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
        //TODO 52 strona
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

    /** Metoda setContractForCustomer z przekazywanym statusem
     *
     */
    public static void setContractForCustomer(Integer customerId, final Boolean status){
        Customer.foreach(Customer.getListCustomerById(Customer.allCustomer,customerId),
                new Foreach1<Customer>() {
                    @Override
                    public void call(Customer customer) {
                        customer.contract.enabled = status;
                    }
                });
        ;}
}
