package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/createCategory/{categoryName}", method = RequestMethod.GET)
    public String createCategory(@PathVariable("categoryName") String categoryName) {
        return categoryService.addNewCategory(categoryName).toString();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String getAllCategories() {
        return categoryService.getAllCategories().toString();
    }
}
