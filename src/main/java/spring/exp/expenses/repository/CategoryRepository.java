package spring.exp.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exp.expenses.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
