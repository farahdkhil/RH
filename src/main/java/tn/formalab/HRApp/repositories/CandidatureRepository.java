package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature,Integer> {
}
