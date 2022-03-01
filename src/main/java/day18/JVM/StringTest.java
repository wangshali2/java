package day18.JVM;

/**
 * @Author wsl
 * @Date 2021-10-13
 * @Description  双亲委派机制
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {

        String s = new String();
        System.out.println(s.getClass().getClassLoader()); //null 核心类库由最高层加载

        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());  //自定义的类由自己加载，sun.misc.Launcher$AppClassLoader@18b4aac2
    }

}
