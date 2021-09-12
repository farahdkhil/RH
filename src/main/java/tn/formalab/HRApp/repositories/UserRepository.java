package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
