package io.github.charlie.sets;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 尚硅谷-宋红康
 * @create 1:23
 */
public class TestTreeMap {
    /*
     * 自然排序举例
     * */
    @Test
    public void test1() {
        TreeMap map = new TreeMap();

        map.put("CC", 45);
        map.put("MM", 78);
        map.put("DD", 56);
        map.put("GG", 89);
        map.put("JJ", 99);

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }

    }

    /*
     * 定制排序
     *
     * */
    @Test
    public void test2() {
        //按照User的姓名的从小到大的顺序排列

        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User1 && o2 instanceof User1) {
                    User1 u1 = (User1) o1;
                    User1 u2 = (User1) o2;

                    return u1.name.compareTo(u2.name);
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });

        map.put(new User1("Tom", 12), 67);
        map.put(new User1("Rose", 23), "87");
        map.put(new User1("Jerry", 2), 88);
        map.put(new User1("Eric", 18), 45);
        map.put(new User1("Tommy", 44), 77);
        map.put(new User1("Jim", 23), 88);
        map.put(new User1("Maria", 18), 34);

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }
    }
}

class User1 implements Comparable {
    String name;
    int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User1() {
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
    @Override
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