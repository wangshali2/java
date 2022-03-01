package day18.JVM;

/**
 * @Author wsl
 * @Date 2021-10-12
 * @Description linking
 * @Version

 */
public class Hello03_ClassLoader {

    public static void main(String[] args) throws InterruptedException {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);  //sun.misc.Launcher$ExtClassLoader@7f31245a

        //获取其上层：引导类加载器用C编写的直接获取不到
        ClassLoader parent = extClassLoader.getParent();
        System.out.println(parent);  //null

        //获取用户自定义类的加载器:默认使用系统类加载器进行加载
        ClassLoader classLoader = Hello03_ClassLoader.class.getClassLoader();
        System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //Java的核心类库→引导类加载器加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);  //null
    }
}
