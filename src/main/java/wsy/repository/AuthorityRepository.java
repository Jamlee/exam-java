package wsy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wsy.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    public Authority findByName(String name);
}
