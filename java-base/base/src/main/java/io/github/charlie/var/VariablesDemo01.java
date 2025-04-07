package io.github.charlie.var;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: 实例变量
 */
public class VariablesDemo01 {
    // 实例变量（非静态字段）
    private String username;
    private String password;

    // 无参构造函数
    public VariablesDemo01() {
    }

    // 带参构造函数
    public VariablesDemo01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 获取用户名
    public String getUsername() {
        return username;
    }

    // 设置用户名
    public void setUsername(String username) {
        this.username = username;
    }

    // 获取密码
    public String getPassword() {
        return password;
    }

    // 设置密码
    public void setPassword(String password) {
        this.password = password;
    }

    // 打印用户名和密码
    public void printCredentials() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

// 使用类Variables的示例
class VariablesDemo01Test {
    public static void main(String[] args) {
        // 创建Variables对象并初始化实例变量
        VariablesDemo01 user = new VariablesDemo01("charlie", "super_admin");

        // 打印用户名和密码
        user.printCredentials();

        // 修改用户名
        user.setUsername("super_admin");

        // 显示更改后的用户名
        user.printCredentials();
    }
}