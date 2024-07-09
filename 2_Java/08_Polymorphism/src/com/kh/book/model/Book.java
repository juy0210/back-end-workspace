package com.kh.book.model;

public class Book {

	
	private String name;
	private int age;
	private int coupon;
	private String booklist;
	private String title;
	
	public Book() {
	}
	public Book(String name, int age, int coupon, String booklist, String title) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.booklist = booklist;
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public String getBooklist() {
		return booklist;
	}
	public void setBooklist(String booklist) {
		this.booklist = booklist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", age=" + age + ", coupon=" + coupon 
				+ ", booklist=" + booklist + ", title=" + title + "]";
	}
	
	
}










