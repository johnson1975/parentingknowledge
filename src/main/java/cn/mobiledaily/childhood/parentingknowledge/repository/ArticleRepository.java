package cn.mobiledaily.childhood.parentingknowledge.repository;

import cn.mobiledaily.childhood.parentingknowledge.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Johnson on 2015/2/28.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("select a from Article a where a.publishDate != null and a.categoryId= ?1 order by a.publishDate desc")
    public List<Article> findByCategoryId(Long categoryId, Pageable pageable);

    @Query("select a from Article a where a.publishDate != null and a.subCategoryId= ?1 order by a.publishDate desc")
    public List<Article> findBySubCategoryId(Long subCategoryId, Pageable pageable);
}
