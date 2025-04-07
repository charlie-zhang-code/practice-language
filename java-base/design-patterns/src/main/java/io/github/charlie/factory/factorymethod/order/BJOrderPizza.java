package io.github.charlie.factory.factorymethod.order;

import io.github.charlie.factory.factorymethod.pizza.BJCheesePizza;
import io.github.charlie.factory.factorymethod.pizza.BJPepperPizza;
import io.github.charlie.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }

}