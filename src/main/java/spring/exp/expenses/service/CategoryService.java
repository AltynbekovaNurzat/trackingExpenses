package spring.exp.expenses.service;

import spring.exp.expenses.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(Integer categoryId);
    String addCategory(Category category);
    String updateCategory(Category category);
    String deleteCategory (Integer categoryId);
    List<Category> getCategoriesByUser(String login, String password);
}
