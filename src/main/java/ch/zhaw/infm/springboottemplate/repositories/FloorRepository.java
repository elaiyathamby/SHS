package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Floor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Zur Floor-Entity passendes Repository-Interface
 */
public interface FloorRepository extends JpaRepository<Floor, Long> {

	Floor findByFloorID(Long id);

	Long deleteByFloorID(Long id);

	List<Floor> findByHouseHouseID(Long id);

	@Query(value = "select * from floor f JOIN f.room r where r.room_sizes2 > ?1", nativeQuery = true)
	List<Floor> findFloorsByRoomSize(int roomSize);
}
