package day01;

/**
 * @Author wsl
 * @Date 2021-08-10
 * @Description
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        //求一个四位数的个位、十位、百位、千位
        //结论：num/相应位数%10
        int num=1234;
        int ge=num/1%10;
        int shi=num/10%10;
        int bai=num/100%10;
        int qian=num/1000%10;
        System.out.println(ge+""+shi+""+bai+""+qian);

        char x = 'x';
        int i = 10;

        System.out.println(x); //x
        System.out.println(true? x : i);       //120
        System.out.println(true? 'x' : 10);	   //x
        System.out.println(true? 'x' : 65538);	// 120
        System.out.println(false? 'x' : 65538);	//65538
        System.out.println(false? x : i);  	   //10
        System.out.println("结果是："+(false? 'x' : 10));   //空

        /**
         * 如果表达式中有一个是变量，按照自动类型转换规则处理成一致的类型；
         * 如果都是常量，如果一个是char，如果另一个是[0~65535]之间的整数按char处理；
         * 如果一个是char，另一个变量不再此范围内，按照自动类型转换规则处理成一致的类型；
         */

    }
}
