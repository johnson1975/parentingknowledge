package cn.mobiledaily.childhood.parentingknowledge.repository;

import cn.mobiledaily.childhood.parentingknowledge.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Johnson on 2015/2/28.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select c from Category c where c.parent = null order by c.sortIndex")
    public List<Category> findAll();
    @Query(value = "select c from Category c where c.parent.id = ?1 order by c.sortIndex")
    public List<Category> findByParent(Long id);
}
