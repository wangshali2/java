package day18.JVM;

/**
 * @Author wsl
 * @Date 2021-10-12
 * @Description linking
 * @Version
 * 1.根据赋值的顺序来执行
 * 2.没有静态变量的赋值或者静态代码块时不会生成类的构造器clinit()
 */
public class Hello02_initial {

    //显示初始化
    private static int a = 1; //prepare：a=0,变量的默认初始值根据类型确定-->initial:a=1.

    //静态初始化
    static {
        a = 10;
        num = 20;
        System.out.println(a);
       // System.out.println(num); 不能调用
    }

    private static int num = 2; //prepare：num=0,-->initial:num=20-->10.

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Hello02_initial.a);  //10
        System.out.println(Hello02_initial.num);  //2

    }
}
