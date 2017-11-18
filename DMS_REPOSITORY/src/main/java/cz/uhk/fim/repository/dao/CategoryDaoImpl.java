package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.entity.Category;
import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.CategoryDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl extends AbstractGenericDAO<Category> implements CategoryDao {

    @Override
    public Category getCategoryById(Long id) {
        return getEntityManager().find(Category.class, id);
    }

    @Override
    public Category getCategoryByName(String name) {
        Query query = getEntityManager().createQuery("from Category where name = :name", Category.class);
        query.setParameter("name", name);
        return getSingleResult(query);
    }

    @Override
    public List<Category> getAllCategories() {
        return getEntityManager().createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category addNewCategory(String name) {
        Category category = getCategoryByName(name);
        if (category == null) {
            category = new Category();
            category.setName(name);
            getEntityManager().persist(category);
        }
        return category;
    }

    @Override
    public Category updateCategory(Long id, String name) {
        Category c = getEntityManager().find(Category.class, id);
        if (c != null) {
            c = new Category();
            c.setName(name);
            getEntityManager().merge(c);
        }
        return c;
    }
}
