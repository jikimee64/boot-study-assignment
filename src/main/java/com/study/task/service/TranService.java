package com.study.task.service;

import com.study.task.domain.translation.dto.ResponseTransClientDto;
import com.study.task.repoisotry.TranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranService {

    private final TranRepository tranRepository;

    public ResponseTransClientDto translate(String query, String srcLang, String targetLang){
        return tranRepository.transText(query, srcLang, targetLang);
    }

}
