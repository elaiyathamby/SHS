package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.repositories.FloorRepository;
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
public class FloorRestController {

	@Autowired
	private FloorRepository floorRepository;

	@RequestMapping(value = "/floor", method = RequestMethod.GET)
	public ResponseEntity<List<Floor>> getFloor() {
		List<Floor> floor = floorRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (floor != null && !floor.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(floor, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/floor/{floorid}", method = RequestMethod.GET)
	public ResponseEntity<List<Floor>> getFloorById(@PathVariable("floorid") Long floorid) {
		Floor floor = floorRepository.findByFloorID(floorid);

		// Wenn die Liste Einträge enthält...
		if (floor != null) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(floor, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/floor/house/{houseid}", method = RequestMethod.GET)
	public ResponseEntity<List<Floor>> getFloorByHouse(@PathVariable("houseid") Long houseid) {
		List<Floor> floor = floorRepository.findByHouseHouseID(houseid);

		// Wenn die Liste Einträge enthält...
		if (floor != null && !floor.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(floor, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/floor/delete/{floorid}", method = RequestMethod.DELETE)
	public void deleteFloor(@PathVariable("floorid") Long floorid) {
		floorRepository.deleteByFloorID(floorid);
	}

	@PostMapping("/floor/newfloor")
	public Floor newFloor(@RequestBody Floor floor) {
		return floorRepository.save(floor);
	}

	@RequestMapping(value = "/floor/update/{floorid}", method = RequestMethod.PUT)
	public ResponseEntity<Floor> updateExistingFloor(@PathVariable("floorid") Long floorid, @RequestBody Floor floor) {

		Floor currentFloor = floorRepository.findByFloorID(floorid);

		currentFloor.setFloorSize(floor.getFloorSize());
		currentFloor.setFloorNumber(floor.getFloorNumber());

		floorRepository.save(currentFloor);
		return new ResponseEntity<Floor>(currentFloor, HttpStatus.OK);
	}
}
