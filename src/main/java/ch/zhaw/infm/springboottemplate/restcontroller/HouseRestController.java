package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.entities.House;
import ch.zhaw.infm.springboottemplate.repositories.HouseRepository;
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
public class HouseRestController {

	@Autowired
	private HouseRepository houseRepository;

	@RequestMapping(value = "/house", method = RequestMethod.GET)
	public ResponseEntity<List<House>> getHouse() {
		List<House> house = houseRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (house != null && !house.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(house, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/house/{houseid}", method = RequestMethod.GET)
	public ResponseEntity<List<House>> getHouseById(@PathVariable("houseid") Long houseID) {
		House house = houseRepository.findByHouseID(houseID);

		// Wenn die Liste Einträge enthält...
		if (house != null) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(house, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/house/delete/{houseid}", method = RequestMethod.DELETE)
	public void deleteHouse(@PathVariable("houseid") Long houseid) {
		houseRepository.deleteByHouseID(houseid);
	}

	@PostMapping("/house/newhouse")
	public House newHouse(@RequestBody House house) {
		return houseRepository.save(house);
	}

	@RequestMapping(value = "/house/update/{houseid}", method = RequestMethod.PUT)
	public ResponseEntity<House> updateExistingHouse(@PathVariable("houseid") Long houseid, @RequestBody House house) {

		House currentHouse = houseRepository.findByHouseID(houseid);

		currentHouse.setHouseSizeM2(house.getHouseSizeM2());
		currentHouse.setAddress(house.getAddress());
		currentHouse.setHouseName(house.getHouseName());

		houseRepository.save(currentHouse);
		return new ResponseEntity<House>(currentHouse, HttpStatus.OK);
	}
}
