package tn.formalab.HRApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.formalab.HRApp.models.Candidature;
import tn.formalab.HRApp.repositories.CandidatureRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("candidats")
public class CandidatureController {
    private  CandidatureRepository candidatureRepository;

    @Autowired
    public CandidatureController(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }

    @PostMapping("/create")
    public Candidature createCandidate(@RequestBody Candidature candidate) {
        return candidatureRepository.save(candidate);

    }

    @GetMapping("/candidats")
    public List<Candidature> getAllCandidates() {
        return candidatureRepository.findAll();
    }


    @DeleteMapping("/candidate/{id}")
    void deleteNote(@PathVariable Integer id) {
        candidatureRepository.deleteById(id);
    }
}
