package com.xiuxian.chat.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * spirng cloud feign传递header
 *
 * @author 陈晓
 * @date 2022/9/11
 */

@Slf4j
@Component
public class FeignHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        /**
         * 获取头部的token
         */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {

                String name = headerNames.nextElement();
                if (name.equals("content-length")){
                    continue;
                }
                String values = request.getHeader(name);
                template.header(name, values);
            }
        }
    }
}
