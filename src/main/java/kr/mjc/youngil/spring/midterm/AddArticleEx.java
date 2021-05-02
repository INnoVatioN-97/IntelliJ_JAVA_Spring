package kr.mjc.youngil.spring.midterm;

import kr.mjc.youngil.java.jdbc.article.Article;
import kr.mjc.youngil.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleDao articleDao = context.getBean(ArticleDao.class);

        Article article = new Article();
        article.setTitle("중간고사 제목");
        article.setContent("""
                내용에 쓸 말이 없네
                공부를 안해서 그런가...""");
        article.setName("오우오우");
        article.setUserId(494);
        articleDao.addArticle(article);
        System.out.println("글을 저장했다!");

    }
}
