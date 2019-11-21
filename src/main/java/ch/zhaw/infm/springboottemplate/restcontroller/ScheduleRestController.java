package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Schedule;
import ch.zhaw.infm.springboottemplate.repositories.ScheduleRepository;
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
public class ScheduleRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private ScheduleRepository scheduleRepository;
    
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ResponseEntity<List<Schedule>> getSchedule(){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Schedule> schedule = scheduleRepository.findAll();
        
        // Wenn die Liste Einträge enthält...
        if(schedule != null && !schedule.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(schedule, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/schedule/{scheduleid}", method = RequestMethod.GET)
    public ResponseEntity<List<Schedule>> getScheduleByID(@PathVariable("scheduleID") Long i){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Schedule> schedule = scheduleRepository.findByScheduleID(i);
        
        // Wenn die Liste Einträge enthält...
        if(schedule != null && !schedule.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(schedule, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
