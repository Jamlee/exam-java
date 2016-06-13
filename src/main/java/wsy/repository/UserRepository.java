package wsy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wsy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
