package io.github.charlie.sets;


import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 尚硅谷-宋红康
 * @create 14:22
 */
public class treeSetTest1 {
    /*
     * 自然排序：针对String类的对象
     * */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        set.add("MM");
        set.add("CC");
        set.add("AA");
        set.add("DD");
        set.add("ZZ");
        //set.add(123);  //报ClassCastException的异常

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
     * 自然排序：针对User类的对象
     * */
    @Test
    public void test2() {
        TreeSet set = new TreeSet();

        set.add(new User("Tom", 12));
        set.add(new User("Rose", 23));
        set.add(new User("Jerry", 2));
        set.add(new User("Eric", 18));
        set.add(new User("Tommy", 44));
        set.add(new User("Jim", 23));
        set.add(new User("Maria", 18));
        //set.add("Tom");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(set.contains(new User("Jack", 23))); //true
    }

    /*
     * 定制排序
     * */
    @Test
    public void test3() {
        //按照User的姓名的从小到大的顺序排列
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    return u1.name.compareTo(u2.name);
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        };
        TreeSet set = new TreeSet(comparator);

        set.add(new User("Tom", 12));
        set.add(new User("Rose", 23));
        set.add(new User("Jerry", 2));
        set.add(new User("Eric", 18));
        set.add(new User("Tommy", 44));
        set.add(new User("Jim", 23));
        set.add(new User("Maria", 18));
        //set.add(new User("Maria",28));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class User implements Comparable {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
    举例：按照age从小到大的顺序排列，如果age相同，则按照name从大到小的顺序排列
    * */
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }

        if (o instanceof User) {
            User user = (User) o;
            int value = this.age - user.age;
            if (value != 0) {
                return value;
            }
            return -this.name.compareTo(user.name);
        }
        throw new RuntimeException("输入的类型不匹配");
    }
}