package io.github.charlie.oop.polymorphism;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: 多态示例3，方法返回值类型体现多态
 */
class PetDemo03 {
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

class CatDemo03 extends PetDemo03 {
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

class DogDemo03 extends PetDemo03 {
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

public class PetShopDemo03 {
    public PetDemo03 sale(String type) {
        switch (type) {
            case "Dog":
                return new DogDemo03();
            case "Cat":
                return new CatDemo03();
        }
        return null;
    }
}

class PetShopDemo03Test {
    public static void main(String[] args) {
        PetShopDemo03 petShopDemo03 = new PetShopDemo03();

        PetDemo03 dog = petShopDemo03.sale("Dog");
        dog.setNickname("TomJ");
        dog.eat();

        PetDemo03 cat = petShopDemo03.sale("Cat");
        cat.setNickname("Tom");
        cat.eat();
    }
}