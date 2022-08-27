package com.liuchq.Moxy.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @description: 微信检查参数实体类
 * @author: liuchq
 * @create: 2022-08-27
 **/
@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WxCheckData {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
