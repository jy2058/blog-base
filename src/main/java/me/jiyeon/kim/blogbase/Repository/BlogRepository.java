package me.jiyeon.kim.blogbase.Repository;

import me.jiyeon.kim.blogbase.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
