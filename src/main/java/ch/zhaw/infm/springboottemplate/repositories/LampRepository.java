package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Lamp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur Lamp-Entity passendes Repository-Interface
 */
public interface LampRepository extends JpaRepository<Lamp, Long> {

	List<Lamp> findByDeviceID(Long id);
}
