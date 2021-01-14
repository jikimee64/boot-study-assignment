package com.study.task.service;

import com.study.task.domain.book.dto.ResponseBookApiDto;
import com.study.task.domain.book.dto.ResponseBookClientDto;
import com.study.task.domain.movie.dto.ResponseMovieClientDto;
import com.study.task.repoisotry.BookRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<ResponseBookClientDto> search(String query) {
        List<ResponseBookApiDto> byQuery = bookRepository.findByQuery(query);

        List<ResponseBookClientDto> byClientList = new ArrayList<>();
        for (int i = 0; i < byQuery.get(0).getItems().size(); i++) {
            byClientList.add(
                new ResponseBookClientDto(
                    byQuery.get(0).getItems().get(i).getTitle(),
                    byQuery.get(0).getItems().get(i).getLink(),
                    byQuery.get(0).getItems().get(i).getAuthor(),
                    byQuery.get(0).getItems().get(i).getPrice(),
                    byQuery.get(0).getItems().get(i).getDiscount()
                ));
        }
        return byClientList;
    }


}
