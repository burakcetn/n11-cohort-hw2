package com.burakcetn.n11bootcampcohorthw2;

import com.burakcetn.n11bootcampcohorthw2.controller.CustomerController;
import com.burakcetn.n11bootcampcohorthw2.controller.OrderController;
import com.burakcetn.n11bootcampcohorthw2.controller.ReceiptController;
import com.burakcetn.n11bootcampcohorthw2.entity.Customer;
import com.burakcetn.n11bootcampcohorthw2.entity.Order;
import com.burakcetn.n11bootcampcohorthw2.entity.Receipt;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Month;
import java.util.List;

@SpringBootApplication
public class N11BootcampCohortHw2Application {

	public static void main(String[] args) {
		SpringApplication.run(N11BootcampCohortHw2Application.class, args);

		CustomerController customerController = new CustomerController();
		OrderController orderController = new OrderController();
		ReceiptController receiptController = new ReceiptController();


		Customer customer1 = new Customer(1,"burakC","teknoloji");
		customerController.save(customer1);
		Customer customer2 = new Customer(2,"ahmet","eğitim");
		customerController.save(customer2);
		Customer customer3 = new Customer(3,"meltem", "hizmet");
		customerController.save(customer3);

		Order order1 = new Order(1,1);
		Order order2 = new Order(2,1);
		Order order3 = new Order(3,2);
		Order order4 = new Order(4,3);
		System.out.println("|----------------------------|");
		orderController.save(customer1,order1);
		orderController.save(customer1,order2);
		orderController.save(customer2,order3);
		orderController.save(customer3,order4);

		Receipt receipt = new Receipt(1,1,1000);
		Receipt receipt1 = new Receipt(2,2,400);
		Receipt receipt2 = new Receipt(3,3,10000);
		Receipt receipt3 = new Receipt(4,1,650);
		Receipt receipt4 = new Receipt(5,2,150);
		System.out.println("|----------------------------|");
		receiptController.save(customer1,receipt);
		receiptController.save(customer2,receipt1);
		receiptController.save(customer2,receipt2);
		receiptController.save(customer1,receipt3);
		receiptController.save(customer3,receipt4);


		System.out.println("|----------------------------|");
		List<Customer> data = customerController.getCustomerList();

		System.out.println("|----------------------------|");
		customerController.filterCustomerByName("c");

		System.out.println("|----------------------------|");
		customerController.filterCustomerByCreateMonth(Month.MARCH);


		System.out.println("|----------------------------|");
		receiptController.listAllReceipt();

		System.out.println("|----------------------------|");
		receiptController.filterReceiptByReceiptHigherThan(1500);

		System.out.println("|----------------------------|");
		receiptController.filterCustomerLowerThan(1500);

		System.out.println("|----------------------------|");
		List<Receipt> filteredList = receiptController.filterReceiptByReceiptHigherThan(1500);

		System.out.println("|----------------------------|");
		receiptController.average(filteredList);



		System.out.println("|----------------------------|");
		receiptController.printSectorByMountAndLowerThan(Month.MARCH,750, data);


	}

}
