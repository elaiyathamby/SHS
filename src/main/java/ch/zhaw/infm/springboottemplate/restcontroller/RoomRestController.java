package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Room;
import ch.zhaw.infm.springboottemplate.repositories.RoomRepository;
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
public class RoomRestController {
    
    // Verdrahten der Repository-Klasse, um Karten in der Datenbank zu finden
    @Autowired
    private RoomRepository roomRepository;
    
    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getRoom(){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Room> room = roomRepository.findAll();
        
        // Wenn die Liste Einträge enthält...
        if(room != null && !room.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(room, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/room/{roomid}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getRoomById(@PathVariable("roomid") Long roomid){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Room> room = roomRepository.findByRoomID(roomid);
        
        // Wenn die Liste Einträge enthält...
        if(room != null && !room.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(room, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/room/floor/{floorid}", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getRoomByFloorId(@PathVariable("floorid") Long floorid){
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        List<Room> room = roomRepository.findByFloorFloorID(floorid);
        
        // Wenn die Liste Einträge enthält...
        if(room != null && !room.isEmpty()){
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(room, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
