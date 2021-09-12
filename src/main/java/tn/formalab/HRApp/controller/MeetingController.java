package tn.formalab.HRApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.HRApp.models.Meeting;
import tn.formalab.HRApp.repositories.MeetingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("meetings")
public class MeetingController {

    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }
    @PostMapping(path = "add")
    public ResponseEntity<Meeting> addProduct(@RequestBody Meeting meeting) {
        System.out.println(meeting.titre);
        Meeting saveMeeting = this.meetingRepository.save(meeting);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveMeeting);
    }
    @GetMapping(path = "all")
    public ResponseEntity<List<Meeting>> getAllmeetings() {
        List<Meeting> meetings = this.meetingRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(meetings);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable Integer id) {
        this.meetingRepository.deleteById(id);
        HashMap<String,String> obj = new HashMap<>();
        obj.put("message", "Product deleted Successfully");
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
    @GetMapping(path = "one/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Integer id) {
        try {
            Meeting meeting = meetingRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(meeting);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Meeting());
        }

    }
    @PatchMapping(path = "update")
    public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) {
        Meeting updateMeeting= this.meetingRepository.save(meeting);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateMeeting);
    }
}
