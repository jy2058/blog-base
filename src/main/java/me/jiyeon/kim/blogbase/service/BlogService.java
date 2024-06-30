package me.jiyeon.kim.blogbase.service;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.domain.Article;
import me.jiyeon.kim.blogbase.Repository.BlogRepository;
import me.jiyeon.kim.blogbase.dto.AddArticleRequestDto;
import me.jiyeon.kim.blogbase.dto.UpdateArticleRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequestDto requestDto) {
        return blogRepository.save(requestDto.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequestDto requestDto) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(requestDto.getTitle(), requestDto.getContent());

        return article;
    }
}
