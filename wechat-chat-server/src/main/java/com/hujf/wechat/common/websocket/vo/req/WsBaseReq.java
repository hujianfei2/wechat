package com.hujf.wechat.common.websocket.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hujf
 * @date 2024/02/08
 * @deprecated  请求过来的消息体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WsBaseReq {
    private Integer type;
    private String date;
}
