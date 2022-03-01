package java.lang;

/**
 * @Author wsl
 * @Date 2021-10-13
 * @Description 沙箱安全机制：防止核心类库Java的包被篡改，不能自定义类
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("测试");  //java.lang.SecurityException: Prohibited package name: java.lang
    }
}
