package io.github.charlie;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 05/05/2025
 * @description Integer 的缓存
 */
public class IntegerDemo {
    public static void main(String[] args) {
        // 示例代码
        Integer a = 10;  // 实际调用Integer.valueOf(10)
        Integer b = 10;
        Integer c = Integer.valueOf(10);
        System.out.println(a == b);  // 输出true，因为使用了缓存对象
        System.out.println(a == c);  // 输出true，因为使用了缓存对象
    }
}
