package com.liuchq.wx.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @description: 微信获取token返回的msg
 * @author: liuchq
 * @create: 2022-08-28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Setter
@Getter
public class WxTokenReturn {
    public String access_token;
    public Integer expires_in;
    public String errcode;
    public String errmsg;
}
