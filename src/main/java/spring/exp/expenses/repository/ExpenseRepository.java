package spring.exp.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exp.expenses.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
