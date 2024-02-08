package com.hujf.wechat.common.websocket.vo.resp;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hujf
 * @date 2024/02/08
 * @deprecated  群成员列表信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMemberResp {


    @ApiModelProperty("uid")
    private Long uid;

    /**
     * @See com.hujf.wechat.common.websocket.enums.WSReqTypeEnum
     */
    @ApiModelProperty("在线状态 1在线 2离线")
    private Integer activeStat;

    @ApiModelProperty("最后一次上下线时间")
    private Date lastOptTime;

}
