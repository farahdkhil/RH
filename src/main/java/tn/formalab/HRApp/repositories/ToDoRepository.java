package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
}
