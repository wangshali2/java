package java.lang;

/**
 * @Author wsl
 * @Date 2021-10-13
 * @Description   沙箱安全机制
 * @Version 1.0
 */
public class String {
    public static void main(String[] args) {
        System.out.println("自定义的String");  //错误: 在类 java.lang.String 中找不到 main 方法
        //由引导类加载器加载，真正的String类中没有main方法。
    }
}
