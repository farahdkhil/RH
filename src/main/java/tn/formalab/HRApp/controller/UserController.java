package tn.formalab.HRApp.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.formalab.HRApp.models.User;
import tn.formalab.HRApp.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "create")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.password = this.bCryptPasswordEncoder.encode(user.password);
        User saveUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @GetMapping(path="all")
    public  ResponseEntity <List<User>> getAllUsers(){
        List <User> users = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    //login
    /*
     *findByEmail
     *comparing account state
     *verification account state
     *generate token
     *nab3ethou e token lel front
     */

    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {

        HashMap<String, Object> response = new HashMap<>();

        User userFromDB = userRepository.findByEmail(user.email);

        if (userFromDB == null) {
            response.put("message", "user not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {

            Boolean compare = this.bCryptPasswordEncoder.matches(user.password, userFromDB.password);

            if (!compare) {
                response.put("message", "user not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {

                if (!userFromDB.accountState) {
                    response.put("message", "user not allowed !");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                } else {
                    String token = Jwts.builder()
                            .claim("data", userFromDB)
                            .signWith(SignatureAlgorithm.HS256, "SECRET")
                            .compact();

                    response.put("token", token);

                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }
            }
        }
    }
}
