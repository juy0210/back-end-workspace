package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {

	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}

	
	
    /*
	 * 피자헛의 불고기 피자 가격은 30000원
	 * 피자 반죽과 함계 도우를 빚다.
	 * 토핑은 불고기를 포함시킨다.
	 * 피자를 180도에서 10분간 구운다.
	 * 피자를 8등분으로 자른다.
	 * 피자를 포장한다.
	 * */


	@Override
	public void info() {
		System.out.println(brand + "의 불고기 피자 가격은 " + price + "원");
	}

	@Override
	public void topping() {
		System.out.println("토핑은 불고기를 포함시킨다.");
	}
	
}

















