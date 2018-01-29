package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/createCategory/{categoryName}")
    public String createCategory(@PathVariable("categoryName") String categoryName) {
        return categoryService.addNewCategory(categoryName).toString();
    }

    @GetMapping("/categories")
    public String getAllCategories() {
        return categoryService.getAllCategories().toString();
    }
    
    @GetMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") Long id, @RequestParam(value = "name") String name) {
        return categoryService.updateCategory(id, name).toString();
    }
}
