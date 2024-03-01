package com.burakcetn.n11bootcampcohorthw2.controller;

import com.burakcetn.n11bootcampcohorthw2.entity.Customer;
import com.burakcetn.n11bootcampcohorthw2.entity.Order;
import com.burakcetn.n11bootcampcohorthw2.errorHandler.GeneralErrorMessage;
import com.burakcetn.n11bootcampcohorthw2.exceptions.AlreadyExist;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class OrderController {
    Set<Order> orderSet = new HashSet<>();




    public void save(Customer customer, Order order){


        order.setCustomerId(customer.getId());
        addOrder(order);
        System.out.println (customer.getId() + "id'li kullanıcının " + order.getId() + " idli order'ı kaydedildi");
    }

    public void addOrder(Order order){
        boolean isExist = orderSet.stream().anyMatch(order1 -> order1.getId() ==(order.getId()));
        if(!isExist){
            orderSet.add(order);
        }
        else {
            throw new AlreadyExist(GeneralErrorMessage.ALREADY_EXIST);
        }
    }
}
