package kr.mjc.youngil.spring.midterm;

import kr.mjc.youngil.java.jdbc.article.Article;
import kr.mjc.youngil.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class UpdateArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleDao articleDao = context.getBean(ArticleDao.class);

        Article article = new Article();
        article.setTitle("수정된 제목");
        article.setArticleId(404);
        article.setContent("오우오우 내용이 수정되네");
        article.setUserId(494);

        int isUpdated = articleDao.updateArticle(article);
        if (isUpdated > 0) log.debug("수정 완료!");
        else log.error("수정 실패!");
    }
}
