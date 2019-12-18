package ch.zhaw.infm.springboottemplate.restcontroller;

import ch.zhaw.infm.springboottemplate.entities.User;
import ch.zhaw.infm.springboottemplate.repositories.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		List<User> user = userRepository.findAll();

		// Wenn die Liste Einträge enthält...
		if (user != null && !user.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserById(@PathVariable("userID") Long userID) {
		List<User> user = userRepository.findByUserID(userID);

		// Wenn die Liste Einträge enthält...
		if (user != null && !user.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user/name/{userName}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserByName(@PathVariable("userName") String userName) {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<User> user = userRepository.findByUserName(userName);

		// Wenn die Liste Einträge enthält...
		if (user != null && !user.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(user, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
