package spring.exp.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exp.expenses.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}

