package com.kh._abstract.step2;

public class PineApplePizza extends Pizza {

	public PineApplePizza(int price, String brand) {
		super(price, brand);
	}

	/*
	 * 잭슨피자의 파인애플 피자 가격은 10000원
	 * 피자 반죽과 함계 도우를 빚다.
	 * 토핑은 파인애플을 포함시킨다.
	 * 피자를 180도에서 10분간 구운다.
	 * 피자를 8등분으로 자른다.
	 * 피자를 포장한다.
	 * */
	
	@Override
	public void info() {
		System.out.println(brand + "의 파인애플 피자 가격은 " + price + "원");
	}

	@Override
	public void topping() {
		System.out.println("토핑은 파인애플을 포함시킨다.");
	}

}
















