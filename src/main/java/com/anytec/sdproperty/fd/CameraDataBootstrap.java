package com.anytec.sdproperty.fd;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

@Component
public class CameraDataBootstrap {

    private static Logger logger = LoggerFactory.getLogger(CameraDataBootstrap.class);

    private int port = 8100;
    private static final int CHANNEL_IDLE_TIMEOUT_SECOND = 120;
    private ServerBootstrap bootstrap = null;
    private EventLoopGroup group = null;

    @Autowired
    private CameraChannelHandler cameraChannelHandler;

    public void init() {

        logger.info("初始化CameraDataBootstrap,建立Channel");
        group = new NioEventLoopGroup();
        try {
            bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new IdleStateHandler(0, 0, CHANNEL_IDLE_TIMEOUT_SECOND, TimeUnit.SECONDS))
                                    .addLast(new CameraByteToMessageDecoder())
                                    .addLast(cameraChannelHandler);
                        }
                    });
            bootstrap.bind().sync();
            logger.info("[[ Camera Server Started ]]");
//			ChannelFuture f = bootstrap.bind().sync();
//			f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void stop() {
        try {
            logger.info("[[ Camera Server shutdowing ]]");
            group.shutdownGracefully().sync();
            logger.info("[[ Camera Server Stoped ]]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
