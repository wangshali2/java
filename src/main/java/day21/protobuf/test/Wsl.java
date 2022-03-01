package day21.protobuf.test;

import com.google.protobuf.InvalidProtocolBufferException;
import day21.protobuf.target.WslProto;

/**
 * @Author wsl
 * @Date 2021-05-19
 * @Description
 * @Version 1.0
 */
public class Wsl {
    public static void main(String[] args) {

        //序列化  proto--->字节
        WslProto.Wsl.Builder builder = WslProto.Wsl.newBuilder();
        builder
                .setName("wsl")
                .setNumber(001)
                .setHobby("喝水")
                .setSkill("玩")
                .setSex(t)
                .addArray(1)
                .addArray(2);


        WslProto.Info.Builder infobuilder = WslProto.Info.newBuilder();
        infobuilder
                .setQq(11111111)
                .setWx(2222222);

        builder.setInfo(infobuilder);

        WslProto.Wsl.Score.Builder scorebuilder = WslProto.Wsl.Score.newBuilder();
        scorebuilder
                .setChinese(99)
                .setHistory(88);
        builder.setScore(scorebuilder);


        WslProto.Wsl wsl = builder.build();

        System.out.println(wsl.toString());

        //反序列化   字节--->对象
        byte[] array = wsl.toByteArray();
        try {
            WslProto.Wsl wsl1 = WslProto.Wsl.parseFrom(array);
            System.out.println("名字：" + wsl1.getName());
            System.out.println("性别：" + wsl1.getSex());
            System.out.println("数字：" + wsl1.getNumber());
            System.out.println("技能：" + wsl1.getSkill());
            System.out.println("info：" + wsl1.getInfo());
            System.out.println("score：" + wsl1.getScore());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


    }
}
