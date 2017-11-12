package cz.uhk.fim.dms.repository.dao.category;

import cz.uhk.fim.dms.repository.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
     * @param name
     * @return
     */
    Category updateCategory(Long id, String name);
}
