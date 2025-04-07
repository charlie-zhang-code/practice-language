package io.github.charlie.oop.polymorphism;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: instanceofe测试
 */
class PetDemo05 {
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

class CatDemo05 extends PetDemo05 {
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

class DogDemo05 extends PetDemo05 {
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

public class InstanceofTest {
    public static void main(String[] args) {
        PetDemo05[] pets = new PetDemo05[2];
        pets[0] = new CatDemo05();
        pets[0].setNickname("Tom");
        pets[1] = new DogDemo05();
        pets[1].setNickname("Jerry");

        for (PetDemo05 pet : pets) {
            if (pet instanceof CatDemo05) {
                ((CatDemo05) pet).catchMouse();
            } else if (pet instanceof DogDemo05) {
                ((DogDemo05) pet).playBall();
            }
        }
    }
}
