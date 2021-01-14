package com.study.task.domain.book.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseBookApiDto {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item{
        private String title;
        private String link;
        private String image;
        private String author;
        private String price;
        private String discount;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;

    }


}
