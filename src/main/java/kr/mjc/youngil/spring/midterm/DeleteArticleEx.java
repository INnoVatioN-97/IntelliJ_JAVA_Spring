package kr.mjc.youngil.spring.midterm;

import kr.mjc.youngil.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class DeleteArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleDao articleDao = context.getBean(ArticleDao.class);

        int isUpdated = articleDao.deleteArticle(409, 494);
        if (isUpdated > 0) log.info("삭제 완료!");
        else log.debug("삭제 실패!");
    }
}
