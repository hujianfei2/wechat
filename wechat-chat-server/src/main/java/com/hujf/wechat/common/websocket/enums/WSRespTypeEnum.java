package com.hujf.wechat.common.websocket.enums;

import com.hujf.wechat.common.websocket.vo.resp.WsBlack;
import com.hujf.wechat.common.websocket.vo.resp.WsFriendApply;
import com.hujf.wechat.common.websocket.vo.resp.WsLoginSuccess;
import com.hujf.wechat.common.websocket.vo.resp.WsLoginUrl;
import com.hujf.wechat.common.websocket.vo.resp.WsMemberChange;
import com.hujf.wechat.common.websocket.vo.resp.WsMessage;
import com.hujf.wechat.common.websocket.vo.resp.WsMsgMark;
import com.hujf.wechat.common.websocket.vo.resp.WsMsgRecall;
import com.hujf.wechat.common.websocket.vo.resp.WsOnlineOfflineNotify;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: ws前端请求类型枚举
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-03-19
 */
@AllArgsConstructor
@Getter
public enum WSRespTypeEnum {
    LOGIN_URL(1, "登录二维码返回", WsLoginUrl.class),
    LOGIN_SCAN_SUCCESS(2, "用户扫描成功等待授权", null),
    LOGIN_SUCCESS(3, "用户登录成功返回用户信息", WsLoginSuccess.class),
    MESSAGE(4, "新消息", WsMessage.class),
    ONLINE_OFFLINE_NOTIFY(5, "上下线通知", WsOnlineOfflineNotify.class),
    INVALIDATE_TOKEN(6, "使前端的token失效，意味着前端需要重新登录", null),
    BLACK(7, "拉黑用户", WsBlack.class),
    MARK(8, "消息标记", WsMsgMark.class),
    RECALL(9, "消息撤回", WsMsgRecall.class),
    APPLY(10, "好友申请", WsFriendApply.class),
    MEMBER_CHANGE(11, "成员变动", WsMemberChange.class),
    ;

    private final Integer type;
    private final String desc;
    private final Class dataClass;

    private static Map<Integer, WSRespTypeEnum> cache;

    static {
        cache = Arrays.stream(WSRespTypeEnum.values()).collect(Collectors.toMap(WSRespTypeEnum::getType, Function.identity()));
    }

    public static WSRespTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
