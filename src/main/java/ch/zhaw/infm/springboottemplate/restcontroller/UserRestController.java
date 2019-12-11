package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.House;
import ch.zhaw.infm.springboottemplate.entities.User;
import ch.zhaw.infm.springboottemplate.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-Controller für die Ressource World
 */
@RestController
public class UserRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private UserRepository userRepository;
   
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser(){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<User> user = userRepository.findAll();
        
        // Wenn die Liste Einträge enthält...
        if(user != null && !user.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserById(@PathVariable Long userID){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<User> user = userRepository.findByUserID(userID);
        
        // Wenn die Liste Einträge enthält...
        if(user != null && !user.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByName(@PathVariable("userName") String userName){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<User> user = userRepository.findByUserName(userName);
        
        // Wenn die Liste Einträge enthält...
        if(user != null && !user.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
