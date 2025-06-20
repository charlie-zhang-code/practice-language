package io.github.charlie.factory.absfactory.order;

import io.github.charlie.factory.absfactory.pizza.BJCheesePizza;
import io.github.charlie.factory.absfactory.pizza.BJPepperPizza;
import io.github.charlie.factory.absfactory.pizza.Pizza;

//这是工厂子类
public class BJFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用的是抽象工厂模式~");
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}