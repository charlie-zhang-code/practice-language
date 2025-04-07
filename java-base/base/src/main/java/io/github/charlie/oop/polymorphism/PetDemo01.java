package io.github.charlie.oop.polymorphism;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: 多态示例1，方法内局部变量的赋值体现多态
 */
public class PetDemo01 {
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

class Cat extends PetDemo01 {
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

class Dog extends PetDemo01 {
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

class PetDemo01Test {
    public static void main(String[] args) {
        // 方法内局部变量的赋值体现多态
        // 多态引用
        PetDemo01 pet = new Cat();
        pet.setNickname("Tom");
        // 多态的表现形式
        // 编译时看父类，只能调用父类的方法，不能调用子类的方法
        // 运行时看子类，如果子类重写了父类的方法，则调用子类的方法
        pet.eat(); // 调用了子类的eat方法
        // pet.catchMouse(); // 编译时看父类，父类没有catchMouse方法，所以报错

        pet = new Cat();
        pet.setNickname("TomJs");
        pet.eat(); // 运行时看子类，子类重写了父类的方法，所以调用子类的方法
    }
}