package io.github.charlie.factory.absfactory.order;

import io.github.charlie.factory.absfactory.pizza.LDCheesePizza;
import io.github.charlie.factory.absfactory.pizza.LDPepperPizza;
import io.github.charlie.factory.absfactory.pizza.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用的是抽象工厂模式~");
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
