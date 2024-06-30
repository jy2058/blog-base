package me.jiyeon.kim.blogbase.service;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.domain.Article;
import me.jiyeon.kim.blogbase.Repository.BlogRepository;
import me.jiyeon.kim.blogbase.dto.AddArticleRequestDto;
import org.springframework.stereotype.Service;

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
}
