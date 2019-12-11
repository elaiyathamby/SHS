package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.repositories.FloorRepository;
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
public class FloorRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private FloorRepository floorRepository;
    
    @RequestMapping(value = "/floor", method = RequestMethod.GET)
    public ResponseEntity<List<Floor>> getFloor(){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Floor> floor = floorRepository.findAll();
        
        // Wenn die Liste Einträge enthält...
        if(floor != null && !floor.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(floor, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/floor/{floorid}", method = RequestMethod.GET)
    public ResponseEntity<List<Floor>> getFloorById(@PathVariable("floorid") Long floorid){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Floor> floor = floorRepository.findByFloorID(floorid);
        
        // Wenn die Liste Einträge enthält...
        if(floor != null && !floor.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(floor, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
