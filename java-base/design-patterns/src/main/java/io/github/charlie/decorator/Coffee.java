package io.github.charlie.decorator;

public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }

}