package cz.uhk.fim.repository.dao.api;


import cz.uhk.fim.repository.entity.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * @param id
     * @return
     */
    Category getCategoryById(Long id);

    /**
     * @param name
     * @return
     */
    Category getCategoryByName(String name);

    /**
     * @return
     */
    List<Category> getAllCategories();

    /**
     * @param name
     * @return
     */
    Category addNewCategory(String name);

    /**
     * @param id
     * @param name
     * @return
     */
    Category updateCategory(Long id, String name);
}
