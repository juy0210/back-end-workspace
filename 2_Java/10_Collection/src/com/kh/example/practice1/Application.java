package com.kh.example.practice1;

import java.util.HashSet;

public class Application {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 6) {
			int random = (int) (Math.random() * 45 + 1); 
			System.out.println(random);
			
			int num = 0;
			int num2 = 0;
			
			if(random != num) {
				System.out.println("로또 번호 : " + random);
			} 
			System.out.println("횟수 : " + count());
		}
	}
}
