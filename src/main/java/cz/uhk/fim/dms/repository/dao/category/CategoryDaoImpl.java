package cz.uhk.fim.dms.repository.dao.category;

import cz.uhk.fim.dms.repository.dao.AbstractGenericDAO;
import cz.uhk.fim.dms.repository.entity.Category;

import javax.persistence.Query;
import java.util.List;

public class CategoryDaoImpl extends AbstractGenericDAO<Category> implements CategoryDao {

    @Override
    public Category getCategoryById(Long id) {
        return getEntityManager().find(Category.class, id);
    }

    @Override
    public Category getCategoryByName(String name) {
        Query query = getEntityManager().createQuery("from category where name = :name", Category.class);
        query.setParameter("name", name);
        return getSingleResult(query);
    }

    @Override
    public List<Category> getAllCategories() {
        return getEntityManager().createQuery("from category", Category.class).getResultList();
    }

    @Override
    public Category addNewCategory(String name) {
        Category c = getEntityManager().find(Category.class, name);
        if (c == null) {
            c = new Category();
            c.setName(name);
            getEntityManager().persist(c);
        }
        return c;
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
