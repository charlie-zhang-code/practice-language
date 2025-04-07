package io.github.charlie.factory.factorymethod.order;

import io.github.charlie.factory.factorymethod.pizza.LDCheesePizza;
import io.github.charlie.factory.factorymethod.pizza.LDPepperPizza;
import io.github.charlie.factory.factorymethod.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }

}
