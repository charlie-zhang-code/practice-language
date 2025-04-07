package io.github.charlie.oop.polymorphism;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: 多态的示例，向下转换
 */
public class PetDemo04 {
    private String nickname;
    private int age;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Pet is eating");
    }
}

class CatDemo04 extends PetDemo04 {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.printf("Cat %s is eating", this.getNickname());
    }

    public void catchMouse() {
        System.out.printf("Cat %s is catching mouse", this.getNickname());
    }
}

class DogDemo04 extends PetDemo04 {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.printf("Dog %s is eating", this.getNickname());
    }

    public void playBall() {
        System.out.printf("Dog %s is playing ball", this.getNickname());
    }
}

class ClassCastTest {
    public static void main(String[] args) {
        // 没有类型转换，编译时类型和运行时类型相同
        DogDemo04 dog = new DogDemo04();

        // 向上转型
        PetDemo04 pet = new DogDemo04(); // pet编译时类型是PetDemo04，运行时类型是DogDemo04
        pet.setNickname("TomJs");
        pet.eat(); // 可以调用父类的方法，但是执行的是子类的方法

        DogDemo04 dog2 = (DogDemo04) pet; // 向下转型，编译时类型是PetDemo04，运行时类型是DogDemo04
        System.out.println(dog2.getNickname());
        dog2.eat(); // 可以调用eat方法
        dog2.playBall(); // 可以调用子类扩展的方法

        CatDemo04 c = (CatDemo04) pet; // 编译通过，语法上，pet的编译时PetDemo04，CatDemo04是PetDemo04的子类，所以可以转换，但是运行时类型是DogDemo04，CatDemo04不是DogDemo04的子类，所以会报错
    }
}