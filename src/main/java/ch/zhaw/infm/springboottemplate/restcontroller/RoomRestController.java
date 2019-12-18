package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Room;
import ch.zhaw.infm.springboottemplate.repositories.RoomRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomRestController {

	@Autowired
	private RoomRepository roomRepository;

	@RequestMapping(value = "/room", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getRoom() {
		List<Room> room = roomRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (room != null && !room.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(room, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/room/{roomid}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getRoomById(@PathVariable("roomid") Long roomid) {
		Room room = roomRepository.findByRoomID(roomid);

		// Wenn die Liste Einträge enthält...
		if (room != null) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(room, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/room/floor/{floorid}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getRoomByFloorId(@PathVariable("floorid") Long floorid) {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Room> room = roomRepository.findByFloorFloorID(floorid);

		// Wenn die Liste Einträge enthält...
		if (room != null && !room.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(room, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/room/delete/{roomid}", method = RequestMethod.DELETE)
	public void deleteRoom(@PathVariable("roomid") Long roomid) {
		roomRepository.deleteByRoomID(roomid);
	}

	@PostMapping("/room/newroom")
	public Room newEmployee(@RequestBody Room room) {
		return roomRepository.save(room);
	}

	@RequestMapping(value = "/room/update/{roomid}", method = RequestMethod.PUT)
	public ResponseEntity<Room> updateExistingRoom(@PathVariable("roomid") Long roomid, @RequestBody Room room) {

		Room currentRoom = roomRepository.findByRoomID(roomid);

		currentRoom.setRoomName(room.getRoomName());
		currentRoom.setRoomSizeM2(room.getRoomSizeM2());

		roomRepository.save(currentRoom);
		return new ResponseEntity<Room>(currentRoom, HttpStatus.OK);
	}
}
