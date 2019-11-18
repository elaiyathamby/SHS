package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.Device;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAllByOrderByIsActive();
    
    List<Device> findByRoomIdFk(Long id);
}
