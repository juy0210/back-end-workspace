package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class A_Date {
	
	/*
	 * Date
	 * - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	 * - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	public void method1() {
		// 기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체 생성
		Date today = new Date();
		System.out.println(today); // Thu Jul 11 11:46:14 KST 2024
		
		Date when = new Date(0);
		System.out.println(when); // Thu Jan 01 09:00:00 KST 1970
		
		System.out.println("getTime : " + today.getTime()); // getTime : 1720667105665 오늘을 뜻하는 숫자
		
		// Deprecated된 기능들!
		System.out.println("getYear : " + (today.getYear() + 1900) + "년"); // getYear : 2024년
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월"); // getMonth : 7월
		System.out.println("getDate : " + today.getDate() + "일"); // getDate : 11일
		System.out.println("getHours : " + today.getHours() + "시"); // getHours : 12시
		System.out.println("getMinutes : " + today.getMinutes() + "분"); // getMinutes : 6분
		System.out.println("getSeconds : " + today.getSeconds() + "초"); // getSeconds : 32초
		// 짝대기 그어져 있지만 쓸 수 는 있지만
		
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (H : 0~23시, h : 1~12시)대소문자 구분
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");
		// a = 오후 
		// (H : 0~23시, h : 1~12시) 대소문자 구분 / 오전 오후 구분
		String formatDate = sdf.format(today);
		// 2024년 7월 11일 (목) 12시 8분 30초
		System.out.println(formatDate); // 2024년 07월 11일 (목) 12시 11분 58초
		
	}
	
	/*
	 * Calendar
	 * - Date 클래스를 개선한 추상 클래스 (JDK 1.1)
	 * - 여전히 단점이 존재
	 * */
	public void method2() {
		/*
		 * 추상 클래스이기 때문에 직접 객체 생성할 수 없다
		 * getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체를 반환
		 * 태국 - BuddhistCalendar, 그 외 - GregorianCalendar
		 * */
		Calendar today = Calendar.getInstance();
		today = new GregorianCalendar();
		System.out.println(today);
		// java.util.GregorianCalendar[time=1720668024229,areFieldsSe....
		
		// 년, 월, 일, 시, 분, 초
		System.out.println("YEAR : " + today.get(Calendar.YEAR) + "년"); // YEAR : 2024년
		System.out.println("MONTH : " + (today.get(Calendar.MONTH)+1) + "월"); // MONTH : 7월
		System.out.println("DATE : " + today.get(Calendar.DATE) + "일"); // DATE : 11일
		System.out.println("HOUR : " + today.get(Calendar.HOUR) + "시"); // HOUR : 0시 0 ~ 11로 계산
		System.out.println("HOUR_OF_DAY : " + today.get(Calendar.HOUR_OF_DAY) + "시");
		// HOUR_OF_DAY : 12시 0 ~ 23로 계산
		System.out.println("MINUTE : " + today.get(Calendar.MINUTE) + "분"); // MINUTE : 30분
		System.out.println("SECOND : " + today.get(Calendar.SECOND) + "초"); // SECOND : 27초
		
		System.out.println();
		
		// 날짜 지정
		Calendar date = Calendar.getInstance();
		date.set(2024, Calendar.JULY, 11); // Thu Jul 11 12:34:29 KST 2024
		
		System.out.println(date.getTime()); // Sun Aug 11 12:33:31 KST 2024
		// 월단위는 +1로 인식해서 8월로 나옴
		// Date 객체로 반환
		
		// SimpleDateFormat 사용 가능
		// 24-07-11 12:35:26
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String result = sdf.format(date.getTime());
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		A_Date a = new A_Date();
//		a.method1();
		a.method2();
//		a.method3();
//		a.method4();
		
	}

}






























