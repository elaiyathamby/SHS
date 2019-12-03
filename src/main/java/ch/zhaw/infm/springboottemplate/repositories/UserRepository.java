package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.House;
import ch.zhaw.infm.springboottemplate.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface UserRepository extends JpaRepository<User, Long> {
   
    
    List<User> findByUserName(String name);
    List<User> findByUserID(Long id);
    
    
    //@Query("SELECT house.houseID FROM user WHERE user.userID = ?1 INNER JOIN user_house On user.userID = user_house.userID INNER JOIN house ON house.houseID = user_house.houseID;")
    //List<House> findAllHouses(Long userID);
    
    
}
