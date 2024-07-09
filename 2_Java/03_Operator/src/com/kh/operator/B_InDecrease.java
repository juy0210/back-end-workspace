package com.kh.operator;

public class B_InDecrease {
	
	/*
	 * 증감 연산자
	 * 
	 * (증감연산자)값; 또는 값(증감연산자);
	 * 
	 * - 값을 1 증가시키거나 1 감소시키는 연산자
	 * - ++ : 값 1 증가
	 * - -- : 값 1 감소
	 * - (증감연산자)값 : 전위 연산으로 먼저 증감 연산을 수행하고 다른 연산을 수행
	 * - 값(증감연산자) : 후위 연산으로 먼저 다른 연산을 수행하고 증감 연산을 수행
	 * */

	public static void main(String[] args) {
		
		B_InDecrease b = new B_InDecrease();
//		b.method1();
		b.method2();
	}
	
	public void method1() {
		int number = 10;
		
		// 전위 연산자
		System.out.println("1회 수행 후 값 : " + ++number); // 11
		System.out.println("2회 수행 후 값 : " + ++number); // 12
		System.out.println("전위 연산자 적용 후 : " + number); // 12
		
		System.out.println();
		
		// 후위 연산자
		System.out.println("1회 수행 후 값 : " + number++); // 12
		System.out.println("2회 수행 후 값 : " + number++); // 13
		System.out.println("후위 연산자 적용 후 : " + number); // 14
	}
	
	public void method2() {
		int number = 20;
		int result = number++ * 3;
		
		System.out.println(number); // 21
		System.out.println(result); // 60 > number를 먼저 3을 곱하는 값이 result에 들어간다
		                            // 그리고 나서 ++를 더한다 그래서 60
		
		int number1 = 10;
		int number2 = 20;
		int number3 = 30;
		
		System.out.println(number1++); // 10
		System.out.println((++number1) + (number2++)); 
		// 32 > 위에 number1에 ++가 더해진다 그리고 + 21 = 32
		System.out.println((number1++) + (--number2) + (number3--)); // 62
		// 위 number1에 2가 더해진 상태 + 위에 number2 1이 더해진 상태에서 -1 +  30 = 62
		
		System.out.println(number1); // 13
		System.out.println(number2); // 20
		System.out.println(number3); // 29
	}

}





