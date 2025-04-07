package io.github.charlie.oop.enums.demo2;

enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class TestEnum {
    public static void main(String[] args) {
        Week monday = Week.MONDAY;
        System.out.println(monday);
    }
}
