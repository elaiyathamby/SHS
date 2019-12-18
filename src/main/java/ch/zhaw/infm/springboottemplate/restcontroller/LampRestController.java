package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Lamp;
import ch.zhaw.infm.springboottemplate.repositories.LampRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LampRestController {

	@Autowired
	private LampRepository lampRepository;

	@RequestMapping(value = "/lamp/{lampID}", method = RequestMethod.GET)
	public ResponseEntity<List<Lamp>> getLampById(@PathVariable("lampID") Long lampID) {
		List<Lamp> lamp = lampRepository.findByDeviceID(lampID);

		// Wenn die Liste Einträge enthält...
		if (lamp != null && !lamp.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(lamp, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/lamp", method = RequestMethod.GET)
	public ResponseEntity<List<Lamp>> getLamps() {
		List<Lamp> lamp = lampRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (lamp != null && !lamp.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(lamp, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
