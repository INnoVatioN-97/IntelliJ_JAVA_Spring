package kr.mjc.youngil.spring.midterm;

import kr.mjc.youngil.java.jdbc.article.Article;
import kr.mjc.youngil.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ListArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleDao articleDao = context.getBean(ArticleDao.class);
        List<Article> articleList = articleDao.listArticles(0, 10);
        for(Article article : articleList){
            System.out.println(article);
        }
    }
}
