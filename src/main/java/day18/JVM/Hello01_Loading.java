package day18.JVM;

/**
 * @Author wsl
 * @Date 2021-10-12
 * @Description 加载Loading
 * @Version
 * hello加载前先加载父类
 */
public class Hello01_Loading {
    public static void main(String[] args) throws InterruptedException {

        int i = 2;
        int j = 3;
        int k = i + j;

        Thread.sleep(6000);

        System.out.println("hello");
    }
}
