package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur House-Entity passendes Repository-Interface
 */
public interface HouseRepository extends JpaRepository<House, Long> {

	House findByHouseID(Long id);

	Long deleteByHouseID(Long id);

}
