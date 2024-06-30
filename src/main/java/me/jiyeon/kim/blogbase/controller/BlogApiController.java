package me.jiyeon.kim.blogbase.controller;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.domain.Article;
import me.jiyeon.kim.blogbase.dto.AddArticleRequestDto;
import me.jiyeon.kim.blogbase.dto.ArticleResponseDto;
import me.jiyeon.kim.blogbase.dto.UpdateArticleRequestDto;
import me.jiyeon.kim.blogbase.service.BlogService;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        List<ArticleResponseDto> articles = blogService.findAll()
                .stream()
                .map(ArticleResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponseDto(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id
            , @RequestBody UpdateArticleRequestDto requestDto) {
        Article updatedArticle = blogService.update(id, requestDto);
        return ResponseEntity.ok().body(updatedArticle);
    }
}
