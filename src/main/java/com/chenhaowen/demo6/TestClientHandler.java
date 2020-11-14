package com.chenhaowen.demo6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/14 3:39 下午
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.ProtoMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.ProtoMessage msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int random = new Random().nextInt(3);
        MyDataInfo.ProtoMessage msg = null;
        if (random == 0) {
            msg = MyDataInfo.ProtoMessage.newBuilder().
                    setDataType(MyDataInfo.ProtoMessage.DataType.Person).
                    setPerson(MyDataInfo.Person.newBuilder().
                            setName("张三").
                            setAge(20).
                            setAddress("上海").
                            build()
                    ).build();
        } else if (random == 1) {
            msg = MyDataInfo.ProtoMessage.newBuilder().
                    setDataType(MyDataInfo.ProtoMessage.DataType.Dog).
                    setDog(MyDataInfo.Dog.newBuilder().
                            setName("狗子").
                            setAge(2).
                            build()
                    ).build();
        } else if (random == 2) {
            msg = MyDataInfo.ProtoMessage.newBuilder().
                    setDataType(MyDataInfo.ProtoMessage.DataType.Cat).
                    setCat(MyDataInfo.Cat.newBuilder().
                            setName("喵咪").
                            setCity("南京").
                            build()
                    ).build();
        }
        ctx.channel().writeAndFlush(msg);
    }


}
