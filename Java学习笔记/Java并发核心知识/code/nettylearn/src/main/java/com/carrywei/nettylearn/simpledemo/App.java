package com.carrywei.nettylearn.simpledemo;

import com.carrywei.nettylearn.simpledemo.HelloServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description： 实现客户端发送一个请求，服务器会返回 hello netty
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        // 定义一对线程组
        // 主线程组，用于接受客户端的连接。但是不做任何处理
        EventLoopGroup parentGroup =  new NioEventLoopGroup();
        // 从线程组，主线程组会把任务丢给他，让他线程去做任务
        EventLoopGroup childGroup = new NioEventLoopGroup();
        // netty服务器的创建，ServerBootstrap是一个启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(parentGroup, childGroup) //设置主从线程组
                    .channel(NioServerSocketChannel.class) // 设置nio的双向通道
                    .childHandler(new HelloServerInitializer()); // 子处理器，用于处理
            // 启动server,并设置端口号，同时启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();

            // 监听关闭的Channel，设置为同步方式
            channelFuture.channel().closeFuture().sync();
        }finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

    }
}
