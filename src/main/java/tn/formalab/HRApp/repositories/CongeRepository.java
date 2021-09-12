package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.Conge;

public interface CongeRepository  extends JpaRepository<Conge,Integer> {
}
