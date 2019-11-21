package ch.zhaw.infm.springboottemplate.restcontroller;

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
    
    /**
     * REST-Ressource für URL /infmapi/v1/worlds/{name} (GET)
     * 
     * @param name        Name einer Welt
     * @return               HTTP-Response mit einem Status 200 oder 404, sowie im ersten Fall einer zur Id passenden Welt-Entität als Body (automatisch als JSON serialisiert)
     *
    @RequestMapping(value = "/infmapi/v1/worlds/{name}", method = RequestMethod.GET)
    public ResponseEntity<World> getWorld(@PathVariable String name){        
        // Zur Id passende Welt suchen
        Optional<World> world = worldRepository.findByName(name);
        
        // Falls Welt gefunden wurde, dann world zurück geben
        if(world.isPresent()) {
            return new ResponseEntity(world.get(), HttpStatus.OK);
        } else {
            // Ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }        
    }*/
    
    /**
     * REST-Ressource für URL /infmapi/v1/worlds (GET)
     * 
     * @return                  HTTP-Response mit einem Status 200 oder 404, sowie im ersten Fall einer Liste aller Welten-Entitäten im JSON-Format
     */
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
}
