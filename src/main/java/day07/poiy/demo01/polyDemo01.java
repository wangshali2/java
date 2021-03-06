package day07.poiy.demo01;

import day07.poiy.demo01.*;

/**
多态：数据类型编译时状态和运行时状态相同时称单态
     数据类型编译时状态和运行时状态不同时称多态
Student s= new Student()//单态
编译时状态：内存中的状态
运行时状态：使用中的状态

多态的前提条件 ：
1.要有子父类继承关系或者将接口实现类的实现关系；
2.必须有方法的重写（因为多态只跟方法的重写有关联，没有重写不会报错，但这种多态没有任何意义）
3.父类的引用指向子类的对象父new子（或子类的对象赋给父类的引用）
父类类名 对象名=new 子类类名();
父接口的引用指向实现类对象：
父接口名 对象名 = new 实现类名();
* */
public class polyDemo01 {
    public static void main(String[] args) {
        A a = new A();//单态

        //父类类名 对象名=new 子类类名();
        A a1= new C();
        A a2= new B();

        //父接口名 对象名 = new 实现类名();
        E e= new F();
    }

}
