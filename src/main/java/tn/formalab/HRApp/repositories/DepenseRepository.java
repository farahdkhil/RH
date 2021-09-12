package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.Depense;

public interface DepenseRepository extends JpaRepository<Depense,Integer> {
}
