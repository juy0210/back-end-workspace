package com.kh.step2.model;

public class Card {
	
	/*
	 * 변수의 종류
	 * 
	 * 1. 지역변수(local variable)
	 * - 메서드 내에 선언되며, 메서드의 종료와 함께 소멸
	 * - 조건문, 반복문 블럭 {} 내에 선언된 지역변수는 블럭을 벗어나면 소멸
	 * 
	 * 2. 인스턴스변수(instance variable) (인스턴스 = 객체)
	 * - 각 인스턴스의 개별적인 저장공간
	 * - 인스턴스 생성 후, '참조변수.인스턴스변수명' 으로 접근
	 * - 인스턴스를 생성할 때 생성되고, 참조변수가 없을 때 가비지컬렉터에 의해 자동제거
	 * 
	 * 3. 클래스변수(class variable) -> static(예약어)
	 * - 같은 클래스의 모든 인스턴스들이 공유하는 변수 
	 * - 인스턴스 생성 없이 '클래스이름.클래스변수명'으로 접근
	 * - 클래스가 메모리에 올라갈 때 생성되고, 프로그램이 종료될 때 소멸
	 * */
	
	// 인스턴스 변수
	public int number; // 숫자
	public String kind; // 모양
	
	// 클래스 변수
	public static int width = 100; // 가로 길이
	public static int height = 250; // 세로 길이

	public static void main(String[] args) {
		
		// 클래스 변수는 객체 생성 없이 호출 가능!
		System.out.println(Card.width);
		System.out.println(Card.height);
		
		Card card1 = new Card(); // 객체 생성
		card1.kind = "Heart";
		card1.number = 7; // Heart 7 이라는 카드 생성
		
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 3;
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
		Card.width = 50;
		card2.height = 90;
		
		System.out.println("첫번째 카드는 " + card1.kind + " " + card1.number + "이며, " 
				          + "크기는 " + card1.width + " X " + card1.height + "입니다.");
		System.out.println("두번째 카드는 " + card2.kind + " " + card2.number + "이며, " 
				          + "크기는 " + card2.width + " X " + card2.height + "입니다.");
		
	}

}















