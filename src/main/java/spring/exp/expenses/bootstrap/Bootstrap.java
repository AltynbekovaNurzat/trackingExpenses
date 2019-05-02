package spring.exp.expenses.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.exp.expenses.entity.Category;
import spring.exp.expenses.entity.Expense;
import spring.exp.expenses.entity.User;
import spring.exp.expenses.repository.CategoryRepository;
import spring.exp.expenses.repository.ExpenseRepository;
import spring.exp.expenses.repository.UserRepository;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("test","tt","123",false);
        User u2 = new User("test2","ll","123",false);
        User u3 = new User("test3","nn","123",false);
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        Category c1 = new Category("accomodation",u1,true);
        Category c2 = new Category("transportation",u1,true);
        Category c3 = new Category("food",u1,true);
        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);

        Expense e1 = new Expense(c1, BigDecimal.TEN,"проживание",u1,true);
        Expense e2 = new Expense(c1, BigDecimal.ONE,"проживание1",u1,true);
        Expense e3 = new Expense(c1, BigDecimal.ONE,"проживание2",u1,true);
        expenseRepository.save(e1);
        expenseRepository.save(e2);
        expenseRepository.save(e3);
    }
}
