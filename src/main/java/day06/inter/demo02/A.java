package day06.inter.demo02;

public interface A {
     default void method() {
        System.out.println("A接口中的默认方法");
    }
}
