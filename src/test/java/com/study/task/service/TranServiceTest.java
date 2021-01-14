package com.study.task.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.study.task.config.KaKaoProperties;
import com.study.task.config.NaverProperties;
import com.study.task.domain.book.dto.ResponseBookClientDto;
import com.study.task.domain.translation.dto.ResponseTransApiDto;
import com.study.task.domain.translation.dto.ResponseTransClientDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(properties = "spring.config.location=" +
    "classpath:/application.yml" +
    ",classpath:/application-secret.yml")
class TranServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KaKaoProperties kaKaoProperties;

    @Autowired
    private TranService tranService;

    @Test
    @DisplayName("Api 응답 데이터 검증")
    void search() {

        String query = "안녕";
        String src_lang = "kr";
        String target_lang = "en";

        ResponseTransClientDto translate = tranService.translate(query, src_lang, target_lang);

        assertThat(translate.getText()).isEqualTo("Hello");

    }

}