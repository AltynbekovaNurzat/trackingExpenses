package spring.exp.expenses.service;

import spring.exp.expenses.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense getExpense(Integer expenseId);
    String addExpense(Expense expense);
    String updateExpense(Expense expense);
    String deleteExpense (Integer expenseId);
    List<Expense> getExpensesByUser(String login, String password);
}
