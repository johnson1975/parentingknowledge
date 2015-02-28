package cn.mobiledaily.childhood.parentingknowledge.service;

import cn.mobiledaily.childhood.parentingknowledge.domain.Article;
import cn.mobiledaily.childhood.parentingknowledge.domain.Category;
import cn.mobiledaily.childhood.parentingknowledge.repository.ArticleRepository;
import cn.mobiledaily.childhood.parentingknowledge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Johnson on 2015/2/28.
 */
@Service(value = "articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getSubCategories(Long id) {
        return categoryRepository.findByParent(id);
    }

    @Override
    public List<Article> getArticlesBy(Long categoryId, int page, int pageSize) {
        Category c = categoryRepository.findOne(categoryId);
        if (c == null) return null;
        PageRequest pq = new PageRequest(page, pageSize);
        if (CollectionUtils.isEmpty(c.getSubCategories())) return articleRepository.findBySubCategoryId(categoryId, pq);
        return articleRepository.findByCategoryId(categoryId, pq);
    }
}
