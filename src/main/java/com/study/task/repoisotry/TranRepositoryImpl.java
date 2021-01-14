package com.study.task.repoisotry;

import com.study.task.config.KaKaoProperties;
import com.study.task.domain.translation.dto.ResponseTransApiDto;
import com.study.task.domain.translation.dto.ResponseTransClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TranRepositoryImpl implements TranRepository {

    private final RestTemplate restTemplate;
    private final KaKaoProperties kaKaoProperties;

    @Override
    public ResponseTransClientDto transText(String query, String srcLang, String targetLang) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", kaKaoProperties.getContentType());
        httpHeaders.add("Authorization", kaKaoProperties.getAuthorization());

        String url = kaKaoProperties.getTranslateUrl() +
            "?query="+ query + "&src_lang=" + srcLang + "&target_lang="+targetLang;

        String text = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders),
            ResponseTransApiDto.class)
            .getBody()
            .getTranslated_text()[0][0];

        return new ResponseTransClientDto(text);
    }
}
