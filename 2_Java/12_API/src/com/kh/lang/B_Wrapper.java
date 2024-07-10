package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
		// int -> Integer
		int iNum = 3;
		String iNum1;
		// Deprecated : 기능은 있지만 비권장
		Integer int1 = new Integer(iNum); // Boxing : 기본 자료형 -> Wrapper 클래스로 전환
		int1 = 3;                          // UnBoxing : Wrapper 클래스 -> 기본 자료형
		
		// double -> Double
		double dNum2 = 3.14;
		Double double2 = new Double(dNum2); // 
		double2 = 3.14;
		
		// char -> Character
		char ch3 = 'a';
		Character ch4 = new Character(ch3);
		ch4 = 'a';
		
		// String과 Wrapper 클래스 간의 변경
		// 1. 문자열을 기본 자료형으로 변경 : parseXXX()
		int iNum11 = Integer.parseInt("20");
		double dNum = Double.parseDouble("34.78");
		
		// 2. 기본 자료형을 문자열로 변경 : String의 valueOf()
		System.out.println(iNum11 + dNum);
		
		
		// String의 valueOf()
		String str1 = String.valueOf(iNum11);
		String str2 = String.valueOf(dNum);
		
		System.out.println(str1 + str2); // 2034.78
		
		// Wrapper 클래스에서 제공한 valueOf().toString()
		String str3 = Integer.valueOf(iNum11).toString();
		String str4 = Double.valueOf(dNum).toString();
		
		System.out.println(str3 + str4); // 2034.78
		
	}
	
	
}



















