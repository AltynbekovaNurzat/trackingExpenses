package spring.exp.expenses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exp.expenses.entity.User;
import spring.exp.expenses.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Integer userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "new user is saved";
    }

    @Override
    public String updateUser(User user) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(user.getId())){
                u.setName(user.getName());
                u.setLogin(user.getLogin());
                u.setPassword(user.getPassword());
                u.setBlocked(user.getBlocked());
                userRepository.save(u);
                return "user is updated";
            }
        }
        return "no user with such id exists to update";
    }

    @Override
    public String deleteUser(Integer userId) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(userId)){
                userRepository.save(u);
                return "user is removed";
            }
        }
        return "no user with such id exists to remove";
    }

    @Override
    public Boolean authUser(String login, String password) {
        boolean notFound = true;
        for (User u : userRepository.findAll()) {
            if (u.getLogin().equals(login)
                    && u.getPassword().equals(password)) {
                notFound = false;
            }
        }
        return notFound;
    }
}
