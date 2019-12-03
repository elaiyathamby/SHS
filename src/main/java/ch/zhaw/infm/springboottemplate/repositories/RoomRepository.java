package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Floor;
import ch.zhaw.infm.springboottemplate.entities.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur House-Entity passendes Repository-Interface
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
   
    List<Room> findByRoomID(Long id);
    
}
