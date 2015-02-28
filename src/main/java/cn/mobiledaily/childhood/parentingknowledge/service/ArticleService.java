package cn.mobiledaily.childhood.parentingknowledge.service;

import cn.mobiledaily.childhood.parentingknowledge.domain.Article;
import cn.mobiledaily.childhood.parentingknowledge.domain.Category;

import java.util.List;

/**
 * Created by Johnson on 2015/2/28.
 */
public interface ArticleService {
    public List<Category> getCategories();

    public List<Category> getSubCategories(Long id);

    public List<Article> getArticlesBy(Long categoryId, int page, int pageSize);

}
