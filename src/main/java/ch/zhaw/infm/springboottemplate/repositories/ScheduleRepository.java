package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Schedule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
    
    List<Schedule> findByScheduleID(Long id);
}
