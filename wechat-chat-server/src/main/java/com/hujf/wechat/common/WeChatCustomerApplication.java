package com.hujf.wechat.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hujf
 * @date 2024/02/06
 * @deprecated  微信的服务启动窗口
 */
@SpringBootApplication(scanBasePackages = {"com.hujf.wechat"})
public class WeChatCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeChatCustomerApplication.class,args);
    }
}
