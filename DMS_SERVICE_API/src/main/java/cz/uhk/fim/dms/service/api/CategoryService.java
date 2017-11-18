package cz.uhk.fim.dms.service.api;


import cz.uhk.fim.repository.entity.Category;

import java.util.List;

public interface CategoryService {

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
     * @param name
     * @return
     */
    Category updateCategory(Long id, String name);
}
