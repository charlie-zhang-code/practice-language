package io.github.charlie.ios;

import java.util.Scanner;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: Scanner 类演示
 */
public class IOS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(str);
        }

        scanner.close();
    }
}
