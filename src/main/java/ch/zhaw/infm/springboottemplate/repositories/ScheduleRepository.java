package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur Schedule-Entity passendes Repository-Interface
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findByScheduleID(Long id);
}
