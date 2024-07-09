package com.kh.overriding;

import java.util.Scanner;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("이준용");
		Customer customer2 = new Customer("이준용");
		
		System.out.println(customer1);
		System.out.println(customer2);
		
		System.out.println(customer1 == customer2); // false
		System.out.println(customer1.equals(customer2)); // false -> true
		
		
		
		VIPCustomer customer3 = new VIPCustomer("이준용");
		VIPCustomer customer4 = new VIPCustomer("이준용");
		
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다."
				, customer1.getName(), customer1.getGrade(), customer1.calcPrice(10000)
				, customer1.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다."
				, customer3.getName(), customer3.getGrade(), customer3.calcPrice(10000)
				, customer3.getBonusPoint());
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다."
				, customer4.getName(), customer4.getGrade(), customer4.calcPrice(10000)
				, customer4.getBonusPoint());
		
		

	}

}




// 		System.out.println(customer3.equals(customer4)); // true
      /*System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다."
        , customer3.getName(), customer3.getGrade(), customer3.bonusRatio()
        , customer3.getSaleRatio());*/


















