package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.entities.House;
import ch.zhaw.infm.springboottemplate.entities.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Zur House-Entity passendes Repository-Interface
 */
public interface HouseRepository extends JpaRepository<House, Long> {
   
    
    List<House> findByHouseID(Long id);
    
    
    
}
