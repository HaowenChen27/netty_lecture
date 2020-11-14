package com.chenhaowen.protobuf;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/14 11:27 上午
 */
public class ProtoBufTest {

    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三")
                .setAge(12).setAddress("上海").build();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(student.toByteArray());
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}
