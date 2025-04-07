package io.github.charlie.oop.abstractd;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/17
 * @Description: 抽象类的运用演示
 */
public class AbstractTestDemo02 {
    public static void main(String[] args) {

    }
}

abstract class Vehicle {
    public abstract double calcFuelEfficiency();
    public abstract double calcTripDistance();
}

class Truck extends Vehicle {

    @Override
    public double calcFuelEfficiency() {
        // TODO
        return 0;
    }

    @Override
    public double calcTripDistance() {
        // TODO
        return 0;
    }
}

class Car extends Vehicle {

    @Override
    public double calcFuelEfficiency() {
        // TODO
        return 0;
    }

    @Override
    public double calcTripDistance() {
        // TODO
        return 0;
    }
}