package cz.uhk.fim.dms.service;

import cz.uhk.fim.repository.entity.Category;
import cz.uhk.fim.repository.dao.api.CategoryDao;
import cz.uhk.fim.dms.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryDao.getCategoryByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Category addNewCategory(String name) {
        return categoryDao.addNewCategory(name);
    }

    @Override
    public Category updateCategory(Long id, String name) {
        return categoryDao.updateCategory(id, name);
    }
}
