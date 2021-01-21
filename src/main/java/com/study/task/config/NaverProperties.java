package com.study.task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverProperties {

    private String movieUrl;
    private String bookUrl;
    private String clientId;
    private String clientSecret;

    public HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", this.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", this.getClientSecret());
        return httpHeaders;
    }
}
