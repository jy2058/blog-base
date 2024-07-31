package me.jiyeon.kim.blogbase.controller;

import lombok.RequiredArgsConstructor;
import me.jiyeon.kim.blogbase.domain.Article;
import me.jiyeon.kim.blogbase.dto.ArticleListViewResponse;
import me.jiyeon.kim.blogbase.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);
        return "articleList";
    }
}
