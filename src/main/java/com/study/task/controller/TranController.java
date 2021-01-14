package com.study.task.controller;

import com.study.task.domain.translation.dto.ResponseTransClientDto;
import com.study.task.service.TranService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class TranController {

    private final TranService tranService;

        @GetMapping("/trans")
        public ResponseTransClientDto translate(@RequestParam(name = "q") String query,
            @RequestParam(name = "src_lang") String srcLang,
            @RequestParam(name = "target_lang") String targetLang){
            return tranService.translate(query, srcLang, targetLang);
    }

}
