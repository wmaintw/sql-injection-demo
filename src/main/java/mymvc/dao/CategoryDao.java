package mymvc.dao;

import mymvc.domain.Category;
import org.springframework.data.repository.Repository;

public interface CategoryDao extends Repository<Category, Long> {
    public void save(Category category);

    public Category findById(int categoryId);
}
