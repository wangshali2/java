package day18.JVM;

/**
 * @Author wsl
 * @Date 2021-10-14
 * @Description
 * @Version 1.0
 */
public class OperandStack {
    public static void main(String[] args) {

    }

    public void test() {
        byte i = 15;  //byte、short、char存储数组里时都是以int存的
        int j = 8;
        int k = i + j;
    }

    public void add() {
       //1.
        int i1=10;
        i1++;

        int i2=10;
        ++i2;

        //2.
        int i3=10;
        int i4=i3++;

        int i5=10;
        int i6=++i5;

    }

}
