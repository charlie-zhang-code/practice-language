package io.github.charlie.oop.enums.demo4;

enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private final String description;

    private Week(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + description;
    }
}

public class TestWeek {
    public static void main(String[] args) {
        Week week = Week.MONDAY;
        System.out.println(week);
        switch (week) {
            case MONDAY:
                System.out.println("怀念周末，困意很浓");
                break;
            case TUESDAY:
                System.out.println("进入学习状态");
                break;
            case WEDNESDAY:
                System.out.println("死撑");
                break;
            case THURSDAY:
                System.out.println("小放松");
                break;
            case FRIDAY:
                System.out.println("又信心满满");
                break;
            case SATURDAY:
                System.out.println("开始盼周末，无心学习");
                break;
            case SUNDAY:
                System.out.println("一觉到下午");
                break;
        }
    }
}
