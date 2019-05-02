package spring.exp.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exp.expenses.entity.Expense;
import spring.exp.expenses.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;

    @Override
    public Expense getExpense(Integer expenseId) {
        return expenseRepository.getOne(expenseId);
    }

    @Override
    public String addExpense(Expense expense) {
        expenseRepository.save(expense);
        return "new category is added";
    }

    @Override
    public String updateExpense(Expense expense) {
        for(Expense e: expenseRepository.findAll())
            if (e.getId().equals(expense.getId())){
                e.setUser(expense.getUser());
                e.setCategory(expense.getCategory());
                e.setAmount(expense.getAmount());
                e.setDescription(expense.getDescription());
                e.setExpense(expense.isExpense());
                expenseRepository.save(e);
                return "expense is updated";
            }
        return "no expense with such id exists to update";
    }

    @Override
    public String deleteExpense(Integer expenseId) {
        for(Expense e: expenseRepository.findAll())
            if (e.getId().equals(expenseId)){
                expenseRepository.delete(e);
                return "expense is removed";
            }
        return "no expense with such id exists to remove";
    }

    @Override
    public List<Expense> getExpensesByUser(String login, String password) {
        List<Expense> expenseList = new ArrayList<>();
        for(Expense e: expenseRepository.findAll())
            if (e.getUser().getLogin().equals(login)
                && e.getUser().getPassword().equals(password)){
                expenseList.add(e);
            }
        return expenseList;
    }
}
