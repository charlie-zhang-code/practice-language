package io.github.charlie.factory.simplefactory.pizza;

public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 给希腊披萨 准备原材料 ");
    }
}