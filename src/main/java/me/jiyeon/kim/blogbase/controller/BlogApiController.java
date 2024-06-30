package me.jiyeon.kim.blogbase.controller;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.domain.Article;
import me.jiyeon.kim.blogbase.dto.AddArticleRequestDto;
import me.jiyeon.kim.blogbase.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequestDto requestDto) {
        Article savedArticle = blogService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
