package com.burakcetn.n11bootcampcohorthw2.controller;

import com.burakcetn.n11bootcampcohorthw2.entity.Customer;
import com.burakcetn.n11bootcampcohorthw2.entity.Receipt;
import com.burakcetn.n11bootcampcohorthw2.errorHandler.GeneralErrorMessage;
import com.burakcetn.n11bootcampcohorthw2.exceptions.AlreadyExist;
import lombok.Getter;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter

public class ReceiptController {

    CustomerController customerController = new CustomerController();

    private final Map<Integer, Receipt> receiptMap = new HashMap<Integer, Receipt>();

    public void save(Customer customer,Receipt receipt){
        addReceipt(receipt);
        System.out.println (customer.getId() + " idli customer'ın " + receipt.getId() + " idli receipt kaydedildi");

    }

    public void addReceipt(Receipt receipt){
        if(!receiptMap.containsKey(receipt.getId())){
            receiptMap.put(receipt.getId(),receipt);
        }else {
            throw new AlreadyExist(GeneralErrorMessage.ALREADY_EXIST);
        }
    }

    public void  listAllReceipt(){
        receiptMap.forEach((key,value)->System.out.println(value.toString()));
    }

    public void filterReceiptByReceiptLowerThan(int bill){
        List<Receipt> filteredReceiptByBill = new ArrayList<>();
        receiptMap.values().stream().filter(receipt -> receipt.getBill() < bill ).forEach(filteredReceiptByBill::add);
        for(Receipt receipt : filteredReceiptByBill){
            System.out.println(receipt.toString());
        }
    }

    public List<Receipt> filterReceiptByReceiptHigherThan(int bill){
        List<Receipt> filteredReceiptByBill = new ArrayList<>();
        receiptMap.values().stream().filter(receipt -> receipt.getBill() > bill ).forEach(filteredReceiptByBill::add);
        for(Receipt receipt : filteredReceiptByBill){
            System.out.println(receipt.toString());
        }
        return filteredReceiptByBill;
    }

    public void average(List<Receipt> data){
        int sum =0;
        for (Receipt receipt:  data){
            sum += receipt.getBill();
        }
        System.out.println("aveage :" +sum/data.size());
    }

    public void filterCustomerLowerThan(int bill){
        List<Receipt> filteredList = new ArrayList<>();
        receiptMap.values().stream().filter(receipt -> receipt.getBill() < bill).forEach(filteredList::add);
       filteredList.forEach(receipt -> System.out.println("receipt id : " +receipt.getId()));
    }


    public void printSectorByMountAndLowerThan(Month month,int bill,List<Customer> data){
        List<Receipt> filteredByMonth = filterByMonth(month);
        filteredByMonth.stream().filter(receipt -> receipt.getBill() < bill).forEach(receipt -> System.out.println(customerController.findById(receipt.getCustomerId(), data).getSector()));
    }

  public List<Receipt> filterByMonth(Month month){
        List<Receipt> filteredList = new ArrayList<>();
        receiptMap.values().stream().filter(receipt -> receipt.getCreatedAt().getMonth() == month).forEach(filteredList::add);
        return filteredList;
    }



}
