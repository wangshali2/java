package day01;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wsl
 * @version 2020091117:00
 * <p>
 * BigInteger
 * 解释:表示比long大的整数
 * 位置：java.math.BigInteger
 * 构造器：public BigInteger(String val)将 BigInteger 的十进制字符串表示形式转换为 BigInteger
 * <p>
 * BigDecimal
 * 解释:精确的十进制的小数
 * 位置：java.math.BigDecimal
 * 构造器：public BigDecimal(String val)将 BigDecimal 的字符串表示形式转换为 BigDecimal。
 */
public class BigDemo {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("1234567891234567890123");
        BigInteger b = new BigInteger("1");


        System.out.println(2.0 - 1.1);//0.89999999
        BigDecimal big = new BigDecimal(2.0);//这种构造器传入的值不准确，不推荐用
        BigDecimal big2 = new BigDecimal(1.1);



        BigDecimal big3 = new BigDecimal("2.0");//String 类的精确
        BigDecimal big4 = new BigDecimal("1.1");

        System.out.println(a.add(b));
        System.out.println(big.subtract(big2));

        BigDecimal zero = BigDecimal.ZERO;
      
    }
}




















