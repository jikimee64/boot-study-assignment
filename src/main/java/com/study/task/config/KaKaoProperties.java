package com.study.task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kakao.openapi")
public class KaKaoProperties {
    private String translateUrl;
    private String authorization;
    private String contentType;
}
