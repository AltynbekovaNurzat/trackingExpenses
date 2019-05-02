package spring.exp.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.exp.expenses.entity.Expense;
import spring.exp.expenses.service.ExpenseService;
import spring.exp.expenses.service.UserService;

import java.util.List;

@RestController
@RequestMapping("expenses/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Expense> getAllExpensesByUser(@RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return expenseService.getExpensesByUser(login,password);
    }

    @GetMapping("/{expenseId}")
    public Expense getExpense(@PathVariable Integer expenseId, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return expenseService.getExpense(expenseId);
    }

    @PutMapping
    public String updateExpense(@RequestBody Expense expense, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return expenseService.updateExpense(expense);
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return expenseService.addExpense(expense);
    }

    @DeleteMapping("/{expenseId}")
    public String deleteCategory(@PathVariable Integer expenseId, @RequestHeader String login, @RequestHeader String password){
        if(userService.authUser(login, password)){
            return null;
        }
        return expenseService.deleteExpense(expenseId);
    }
}
