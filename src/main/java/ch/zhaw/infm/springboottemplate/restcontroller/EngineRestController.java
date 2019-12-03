package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Engine;
import ch.zhaw.infm.springboottemplate.entities.Room;
import ch.zhaw.infm.springboottemplate.repositories.EngineRepository;
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
public class EngineRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private EngineRepository engineRepository;
    
    /**
     * REST-Ressource für URL /infmapi/v1/worlds/{name} (GET)
     * 
     * @param name        Name einer Welt
     * @return               HTTP-Response mit einem Status 200 oder 404, sowie im ersten Fall einer zur Id passenden Welt-Entität als Body (automatisch als JSON serialisiert)
     *
    @RequestMapping(value = "/device/active", method = RequestMethod.GET)
    public ResponseEntity<Device> getWorld(@PathVariable String name){        
        // Zur Id passende Welt suchen
        List<Device> device = deviceRepository.findAllByOrderByIsActive();
        
        // Falls Welt gefunden wurde, dann world zurück geben
        if(device.isPresent()) {
            return new ResponseEntity(device.get(), HttpStatus.OK);
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
    @RequestMapping(value = "/engine/{engineId}", method = RequestMethod.GET)
    public ResponseEntity<List<Engine>> getDevices(@PathVariable("room") Long engineId){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Engine> engine = engineRepository.findByDeviceID(engineId);
        
        // Wenn die Liste Einträge enthält...
        if(engine != null && !engine.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(engine, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
