package tn.formalab.HRApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.HRApp.models.Meeting;

public interface MeetingRepository  extends JpaRepository<Meeting,Integer> {
}
