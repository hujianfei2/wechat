package com.hujf.wechat.common.websocket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hujf
 * @date 2024/02/08
 * @deprecated  用户在线状态
 */
@AllArgsConstructor
@Getter
public enum WsReqTypeEnum {
    LOGIN(1, "请求登录二维码"),
    HEARTBEAT(2, "心跳包"),
    AUTHORIZE(3, "登录认证");

    private final Integer type;
    private final String desc;

    private static Map<Integer, WsReqTypeEnum> cache;

    static {
        cache = Arrays.stream(WsReqTypeEnum.values()).collect(Collectors.toMap(WsReqTypeEnum::getType, Function.identity()));
    }

    public static WsReqTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
