package com.study.task.repoisotry;

import com.study.task.domain.translation.dto.ResponseTransClientDto;

public interface TranRepository {
    ResponseTransClientDto transText(String query, String srcLang, String targetLang);
}
