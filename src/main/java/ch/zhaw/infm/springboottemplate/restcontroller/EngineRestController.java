package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Engine;
import ch.zhaw.infm.springboottemplate.repositories.EngineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EngineRestController {

	@Autowired
	private EngineRepository engineRepository;

	@RequestMapping(value = "/engine/{engineId}", method = RequestMethod.GET)
	public ResponseEntity<List<Engine>> getEngineById(@PathVariable("engineId") Long engineId) {
		List<Engine> engine = engineRepository.findByDeviceID(engineId);

		// Wenn die Liste Einträge enthält...
		if (engine != null && !engine.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(engine, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/engine", method = RequestMethod.GET)
	public ResponseEntity<List<Engine>> getEngine() {
		List<Engine> engine = engineRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (engine != null && !engine.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(engine, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
