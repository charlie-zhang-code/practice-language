package io.github.charlie.error.demo2;

import java.io.IOException;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/3
 * @Description: TODO
 */
public class F {
    public void method() throws Exception {
        System.out.println("Father.method");
    }
}

class E extends F {
    public void method() throws Exception {
        System.out.println("Child.method");
    }
}

class D extends F {
    public void method() throws IOException, ClassCastException {
        System.out.println("Child.method");
    }
}
