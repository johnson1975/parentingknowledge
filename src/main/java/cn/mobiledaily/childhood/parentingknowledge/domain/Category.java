package cn.mobiledaily.childhood.parentingknowledge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johnson on 2015/2/28.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category implements Serializable {
    private static final long serialVersionUID = -4228260522787305987L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    @JsonIgnore
    private Category parent;
    @OneToMany(targetEntity = Category.class, cascade = {CascadeType.ALL}, mappedBy = "parent")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy(value = "sortIndex")
    private List<Category> subCategories;
    private String name;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private Long sortIndex;
    @JsonIgnore
    private boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
