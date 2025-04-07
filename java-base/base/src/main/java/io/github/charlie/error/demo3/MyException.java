package io.github.charlie.error.demo3;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/3
 * @Description: TODO
 */
public class MyException extends Exception {
    static final long serialVersionUID = 1L;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
