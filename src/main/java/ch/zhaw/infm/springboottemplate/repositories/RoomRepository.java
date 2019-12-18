package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur Room-Entity passendes Repository-Interface
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

	Room findByRoomID(Long id);

	List<Room> findByFloorFloorID(Long id);

	Long deleteByRoomID(Long id);

}
