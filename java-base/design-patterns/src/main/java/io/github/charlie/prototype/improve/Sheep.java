package io.github.charlie.prototype.improve;

import lombok.Data;

@Data
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    private String address = "蒙古羊";
    public Sheep friend; // 是对象, 克隆默认为浅拷贝

    public Sheep(String name, int age, String color) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    protected Object clone() {

        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
