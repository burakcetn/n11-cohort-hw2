package com.burakcetn.n11bootcampcohorthw2.controller;

import com.burakcetn.n11bootcampcohorthw2.entity.Customer;
import com.burakcetn.n11bootcampcohorthw2.errorHandler.GeneralErrorMessage;
import com.burakcetn.n11bootcampcohorthw2.exceptions.AlreadyExist;
import lombok.Getter;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter

public class CustomerController {


    private final List<Customer> customerList = new ArrayList<>();


    public void save(Customer customer){
        customerList.add(customer);
        System.out.println (customer.getId()+" id'li customer kaydedildi");
    }


    public void addToCustomerList(Customer customer){
        boolean isExist = customerList.stream().anyMatch(customer1 -> Objects.equals(customer1.getId(), customer.getId()));
        if(!isExist){
            customerList.add(customer);
            System.out.println("customer " + customer.getName() + " kaydedildi");
        }else {
            throw new AlreadyExist(GeneralErrorMessage.ALREADY_EXIST);
        }
    }

    public List<Customer> getCustomerList() {
        customerList.forEach(customer -> System.out.println(customer.toString()));
        return customerList;
    }

    public void filterCustomerByName(String a){
        List<Customer> filteredCustomerList = customerList.stream().filter(customer -> customer.getName().toLowerCase().contains(a)).toList();
        for(Customer customer:filteredCustomerList){
            System.out.println(customer.toString());
        }
    }

    public void filterCustomerByCreateMonth(Month month){
        List<Customer> filteredCustomerList = customerList.stream().filter(customer -> customer.getCreatedAt().getMonth() == month).toList();
        for (Customer customer : filteredCustomerList){
            System.out.println(customer.toString());
        }
    }

    public Customer findByIdWithControl(int customerId) {
        for (Customer customer : customerList) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public Customer findById(Integer customerId, List<Customer> customerList) {
       return customerList.stream().filter(a -> a.getId().equals(customerId)).toList().getFirst();
    }
}
