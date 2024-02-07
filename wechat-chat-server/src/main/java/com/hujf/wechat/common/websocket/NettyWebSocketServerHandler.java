package com.hujf.wechat.common.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author hujf
 * @date 2024/02/08
 * @deprecated  微信的消息处理中心
 */
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 读取客户端发送的请求报文
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        String text = msg.text();
        System.out.println("通过netty实现的websocket，发过来的消息是：" + text);
    }
}
