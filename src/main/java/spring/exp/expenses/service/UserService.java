package spring.exp.expenses.service;

import spring.exp.expenses.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Integer userId);
    List<User> getAllUsers();
    String addUser(User user);
    String updateUser(User user);
    String deleteUser(Integer userId);
    Boolean authUser(String login, String password);
}
