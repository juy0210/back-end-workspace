package com.kh.practice.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Member {
	
	private String name;
	private int age;
	private int coupon;
	private ArrayList<Book> bookList = new ArrayList<>();
	
	public Member() {
	}
	public Member(String name, int age, int coupon, ArrayList<Book> bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList=" + bookList + "]";
	}
	
	
}
