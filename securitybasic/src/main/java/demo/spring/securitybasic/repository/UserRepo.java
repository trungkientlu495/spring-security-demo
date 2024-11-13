package demo.spring.securitybasic.repository;

import demo.spring.securitybasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
