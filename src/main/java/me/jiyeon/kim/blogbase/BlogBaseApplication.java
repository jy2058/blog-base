package me.jiyeon.kim.blogbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	// created_at, updated_at 자동 업데이트
public class BlogBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBaseApplication.class, args);
	}

}
