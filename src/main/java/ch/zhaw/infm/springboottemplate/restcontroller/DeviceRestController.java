/*package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Device;
import ch.zhaw.infm.springboottemplate.entities.Room;
import ch.zhaw.infm.springboottemplate.repositories.DeviceRepository;
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
 *//*
@RestController
public class DeviceRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private DeviceRepository deviceRepository;
    
    @RequestMapping(value = "/device/{room}", method = RequestMethod.GET)
    public ResponseEntity<List<Device>> getDevicesForRoom(@PathVariable("room") Room room){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Device> devices = deviceRepository.findByRoom(room);
        
        // Wenn die Liste Einträge enthält...
        if(devices != null && !devices.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(devices, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
*/