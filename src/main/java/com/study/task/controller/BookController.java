package com.study.task.controller;

import com.study.task.domain.book.dto.ResponseBookApiDto;
import com.study.task.domain.book.dto.ResponseBookClientDto;
import com.study.task.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class BookController {

    private final BookService bookService;

    @GetMapping("books")
    public List<ResponseBookClientDto> getBooksByQuery(@RequestParam(name = "q") String query) {
        return bookService.search(query);
    }

}
