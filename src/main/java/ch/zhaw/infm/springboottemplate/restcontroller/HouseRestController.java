package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.entities.House;
import ch.zhaw.infm.springboottemplate.repositories.HouseRepository;
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
public class HouseRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private HouseRepository houseRepository;
    
    
    
    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public ResponseEntity<List<House>> getHouse(){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<House> house = houseRepository.findAll();
        
        // Wenn die Liste Einträge enthält...
        if(house != null && !house.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(house, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/house/floors/{houseID}", method = RequestMethod.GET)
    public ResponseEntity<List<House>> getFloorsFromHouse(@PathVariable Long houseID){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Floor> floors = houseRepository.findFloorByHouseID(houseID);
        
        // Wenn die Liste Einträge enthält...
        if(floors != null && !floors.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(floors, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
