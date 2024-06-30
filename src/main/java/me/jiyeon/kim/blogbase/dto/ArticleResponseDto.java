package me.jiyeon.kim.blogbase.dto;

import lombok.Getter;
import me.jiyeon.kim.blogbase.domain.Article;

@Getter
public class ArticleResponseDto {
    private final String title;
    private final String content;

    public ArticleResponseDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
