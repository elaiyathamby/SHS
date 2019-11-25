package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur House-Entity passendes Repository-Interface
 */
public interface FloorRepository extends JpaRepository<Floor, Long> {
   
    
    //List<Floor> findByHouseID(Long id);
    
    
}
