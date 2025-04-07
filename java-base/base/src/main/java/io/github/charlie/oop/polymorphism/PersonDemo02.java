package io.github.charlie.oop.polymorphism;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: 多态示例2，方法的形参声明体现多态
 */
class PetDemo02 {
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

class CatDemo02 extends PetDemo02 {
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

class DogDemo02 extends PetDemo02 {
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

public class PersonDemo02 {
    private PetDemo02 petDemo02;

    public void adopt(PetDemo02 petDemo02) { // 形参是父类类型，实参是子类对象
        this.petDemo02 = petDemo02;
    }

    public void feed() {
        this.petDemo02.eat(); // 实际引用对象类型不同，执行的eat方法不同
    }
}

class PersonDemo02Test {
    public static void main(String[] args) {
        PersonDemo02 personDemo02 = new PersonDemo02();

        DogDemo02 dogDemo02 = new DogDemo02();
        dogDemo02.setNickname("Tom");
        personDemo02.adopt(dogDemo02); // 实参是dog子类对象，形参是父类pet类型
        personDemo02.feed();

        CatDemo02 catDemo02 = new CatDemo02();
        catDemo02.setNickname("TomJ");
        personDemo02.adopt(catDemo02); // 实参是cat子类对象，形参是父类pet类型
        personDemo02.feed();
    }
}
