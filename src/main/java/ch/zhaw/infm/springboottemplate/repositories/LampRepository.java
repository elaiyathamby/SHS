package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Lamp;
import ch.zhaw.infm.springboottemplate.entities.Room;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface LampRepository extends JpaRepository<Lamp, Long> {
    
    List<Lamp> findByDeviceID(Long id);
}
