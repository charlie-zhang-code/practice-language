package io.github.charlie.sets.s;

import org.junit.Test;

import java.text.Collator;
import java.util.*;

class Man implements Comparable<Man> {
    private String name;
    private int age;
    private int score;
    private int score2;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Man o) {
        return this.age - o.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class TestCollections {
    @Test
    public void test01() {
        /*
        public static <T> boolean addAll(Collection<? super T> c,T... elements)
        将所有指定元素添加到指定 collection 中。Collection的集合的元素类型必须>=T类型
        */
        Collection<Object> coll = new ArrayList<>();
        Collections.addAll(coll, "hello", "java");
        Collections.addAll(coll, 1, 2, 3, 4);

        Collection<String> coll2 = new ArrayList<>();
        Collections.addAll(coll2, "hello", "java");
        //Collections.addAll(coll2, 1,2,3,4);//String和Integer之间没有父子类关系
    }

    @Test
    public void test02() {
        /*
         * public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
         * 在coll集合中找出最大的元素，集合中的对象必须是T或T的子类对象，而且支持自然排序
         *
         *  public static <T> T max(Collection<? extends T> coll,Comparator<? super T> comp)
         *  在coll集合中找出最大的元素，集合中的对象必须是T或T的子类对象，按照比较器comp找出最大者
         *
         */
        List<Man> list = new ArrayList<>();
        list.add(new Man("张三", 23));
        list.add(new Man("李四", 24));
        list.add(new Man("王五", 25));

        /*
         * Man max = Collections.max(list);//要求Man实现Comparable接口，或者父类实现
         * System.out.println(max);
         */

        Man max = Collections.max(list, new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o2.getAge() - o2.getAge();
            }
        });
        System.out.println(max);
    }

    @Test
    public void test03() {
        /*
         * public static void reverse(List<?> list)
         * 反转指定列表List中元素的顺序。
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void test04() {
        /*
         * public static void shuffle(List<?> list)
         * List 集合元素进行随机排序，类似洗牌，打乱顺序
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");

        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void test05() {
        /*
         * public static <T extends Comparable<? super T>> void sort(List<T> list)
         * 根据元素的自然顺序对指定 List 集合元素按升序排序
         *
         * public static <T> void sort(List<T> list,Comparator<? super T> c)
         * 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
         */
        List<Man> list = new ArrayList<>();
        list.add(new Man("张三", 23));
        list.add(new Man("李四", 24));
        list.add(new Man("王五", 25));

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName());
            }
        });
        System.out.println(list);
    }

    @Test
    public void test06() {
        /*
         * public static void swap(List<?> list,int i,int j)
         * 将指定 list 集合中的 i 处元素和 j 处元素进行交换
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world");

        Collections.swap(list, 0, 2);
        System.out.println(list);
    }

    @Test
    public void test07() {
        /*
         * public static int frequency(Collection<?> c,Object o)
         * 返回指定集合中指定元素的出现次数
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world", "hello", "hello");
        int count = Collections.frequency(list, "hello");
        System.out.println("count = " + count);
    }

    @Test
    public void test08() {
        /*
         * public static <T> void copy(List<? super T> dest,List<? extends T> src)
         * 将src中的内容复制到dest中
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {//1-5
            list.add(i);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 11; i <= 13; i++) {//11-13
            list2.add(i);
        }

        Collections.copy(list, list2);
        System.out.println(list);

        List<Integer> list3 = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {//11-20
            list3.add(i);
        }
        //java.lang.IndexOutOfBoundsException: Source does not fit in dest
        //Collections.copy(list, list3);
        //System.out.println(list);

    }

    @Test
    public void test09() {
        /*
         * public static <T> boolean replaceAll(List<T> list，T oldVal，T newVal)
         * 使用新值替换 List 对象的所有旧值
         */
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "java", "world", "hello", "hello");

        Collections.replaceAll(list, "hello", "song");
        System.out.println(list);
    }
}