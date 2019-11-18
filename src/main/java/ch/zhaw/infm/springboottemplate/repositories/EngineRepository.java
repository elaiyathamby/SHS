package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Engine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface EngineRepository extends JpaRepository<Engine, Long> {
    List<Engine> findAllByOrderByIsActive();
    
    List<Engine> findByRoomID(Long id);
}
