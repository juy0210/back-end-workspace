package com.kh.book;

import java.util.Scanner;

import com.kh.book.controller.BookController;

public class Application {

	private Scanner sc = new Scanner(System.in);
	
	private BookController bc = new BookController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
		
	}
	
	public void mainMenu() {
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.println("메뉴 번호 : ");
		int num = sc.nextInt();
		
		System.out.println("1번 도서 : ");
		String title1 = sc.nextLine();
		System.out.println("2번 도서 : ");
		String title2 = sc.nextLine();
		System.out.println("3번 도서 : ");
		String title3 = sc.nextLine();
		System.out.println("4번 도서 : ");
		String title4 = sc.nextLine();
		System.out.println("대여할 도서 번호 선택");
		int booklist = sc.nextInt();
	}

	public void insertMember() {
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("나이 : ");
		int age = sc.nextInt();
		System.out.println("쿠폰 : ");
		int coupon = sc.nextInt();
		
	}
	
	public void updateMember() {
		
	}
}





















