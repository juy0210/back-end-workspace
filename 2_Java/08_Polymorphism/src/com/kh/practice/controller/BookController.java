package com.kh.practice.controller;

import java.util.ArrayList;

import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

public class BookController {
	
	private Member member = new Member();
	int number = 0;
	
	// 내 정보 추가
	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	// 마이페이지
	public Member myPage() {
		return member;
	}
	
	// 책 대여
	public String rentcom.kh.book.model.Book(Book book) {
		ArrayList<book> bookList = member.getBookList();
		
		// 이미 대여한 책은 대여 불가능하게 만들어야 하는 경우
		for(Book value : bookList) {
			if(value != null && book.equals(book)) {
				return "이미 대여한 책입니다.";
			}
		}
		if(bookList.size() < 2) {
			if(member.getAge() < book.getAccessAge()) {
				return "나이 제한으로 대여 불가능입니다.";
			}

		    bookList.add(book);
		    
			// 쿠폰을 가지고 있는 경우
			if(book.isCoupon()) {
				member.setCoupon(member.getCoupon() + 1);
			}
			return"성공적으로 대여되었습니다.";
		}
		return "더 이상 대여할 수 없습니다.";
	}
}

