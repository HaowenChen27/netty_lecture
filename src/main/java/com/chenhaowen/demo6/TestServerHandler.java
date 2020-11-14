package com.chenhaowen.demo6;

import com.google.gson.stream.JsonToken;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/14 3:27 下午
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.ProtoMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.ProtoMessage msg) throws Exception {
        MyDataInfo.ProtoMessage.DataType dataType = msg.getDataType();
        if (dataType == MyDataInfo.ProtoMessage.DataType.Person) {
            MyDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
        } else if (dataType == MyDataInfo.ProtoMessage.DataType.Dog) {
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else if (dataType == MyDataInfo.ProtoMessage.DataType.Cat) {
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
