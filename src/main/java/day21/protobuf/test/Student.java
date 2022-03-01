package day21.protobuf.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import day21.protobuf.target.StudentProto;
import target.StudentProto;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021-05-19
 * @Description protobuf是一种数据交换的格式，以二进制的格式进行数据交换，主要用于网络传输、配置文件、数据存储等诸多领域
 * @Version 1.0
 */
public class Student {
    public static void main(String[] args) {
        //序列化 获取Student对象
        //这里的Student对象构造器被私有化,我们通过Student的内部类Builder来构建builder
        StudentProto.Student.Builder builder = StudentProto.Student.newBuilder();
        builder.setId(1001)
                .setName("王莎莉")
                .setEmail("111111111@qq.com")
                .setSex(StudentProto.Student.Sex.MAN);


        //获取PhoneNumber对象
        StudentProto.Student.PhoneNumber.Builder builder1 = StudentProto.Student.PhoneNumber.newBuilder();

        StudentProto.Student.PhoneNumber pn = builder1
                .setNumber("2222222")
                .setType(StudentProto.Student.PhoneType.MOBILE)
                .build();


        builder.addPhone(pn);

        //再创建1个PhoneNumber对象
        StudentProto.Student.PhoneNumber pn2 = StudentProto.Student.PhoneNumber
                .newBuilder()
                .setNumber("3")
                .setType(StudentProto.Student.PhoneType.HOME)
                .build();

        builder.addPhone(pn2);


        //TODO 序列化
        StudentProto.Student stu = builder.build();
        System.out.println("protobuf数据大小stu: " + stu.toByteString().size());
        System.out.println("----------------------------------");
        System.out.println(stu.toString());//①将proto的message--->Java的class成功

        //②再将封装有数据的对象实例-->字节数组，用于数据传输、存储等
        byte[] stuByte = stu.toByteArray();

        System.out.println("---------------------------------------------");
        // TODO  将字节数据反序列化为对应的对象实例
        StudentProto.Student student = null;
        try {
            student = StudentProto.Student.parseFrom(stuByte);
            //这里得到了Student实例了，就可以根据需要来操作里面的数据了
            System.out.println("学生ID:" + student.getId());
            System.out.println("姓名：" + student.getName());
            System.out.println("性别：" + (student.getSex().getNumber() == 0 ? "男" : "女"));
            System.out.println("邮箱：" + student.getEmail());
            //遍历phoneNumber字段
            List<StudentProto.Student.PhoneNumber> phList = student.getPhoneList();
            for (StudentProto.Student.PhoneNumber p : phList) {
                System.out.println(p.getType() + "电话:" + p.getNumber());
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        //proto-->json格式化
        String jsonObject = JsonFormat.printToString(student);

        System.out.println(jsonObject.toString());
        System.out.println("json数据大小: " + jsonObject.getBytes().length);


        //json-->proto


    }

}

