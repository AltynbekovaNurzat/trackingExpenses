package spring.exp.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.exp.expenses.entity.Category;
import spring.exp.expenses.service.CategoryService;
import spring.exp.expenses.service.UserService;

import java.util.List;

@RestController
@RequestMapping("expenses/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Category> getAllCategoriesByUser(@RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return categoryService.getCategoriesByUser(login,password);
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable Integer categoryId,@RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return categoryService.getCategory(categoryId);
    }

    @PutMapping
    public String updateCategory(@RequestBody Category category, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return categoryService.updateCategory(category);
    }

    @PostMapping
    public String addCategory(@RequestBody Category category, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return categoryService.deleteCategory(categoryId);
    }
}
