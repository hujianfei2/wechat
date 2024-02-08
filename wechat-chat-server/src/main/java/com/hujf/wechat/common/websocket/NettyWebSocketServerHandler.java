package com.hujf.wechat.common.websocket;

import cn.hutool.json.JSONUtil;
import com.hujf.wechat.common.websocket.enums.WsReqTypeEnum;
import com.hujf.wechat.common.websocket.vo.req.WsBaseReq;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author hujf
 * @date 2024/02/08
 * @deprecated 微信的消息处理中心
 */
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);

        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            System.out.println("握手完成");
        }
        if (evt instanceof IdleStateEvent) {
            if (((IdleStateEvent) evt).state() == IdleState.READER_IDLE) {
                System.out.println("读空闲");
                //todo 用户下线
                ctx.channel().close();
            }
        }
    }

    // 读取客户端发送的请求报文
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        String text = msg.text();
        // System.out.println("通过netty实现的websocket，发过来的消息是：" + text);

        WsBaseReq wsBaseReq = JSONUtil.toBean(text, WsBaseReq.class);

        switch (WsReqTypeEnum.of(wsBaseReq.getType())) {
            case LOGIN:
                System.out.println("请求二维码");
                ctx.channel().writeAndFlush(new TextWebSocketFrame("123"));
            case AUTHORIZE:
                break;
            case HEARTBEAT:
                break;
            default:
                System.out.println("没有对应的值");
        }

    }
}
