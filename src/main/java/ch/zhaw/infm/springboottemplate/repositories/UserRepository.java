package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface UserRepository extends JpaRepository<User, Long> {
   
    
    List<User> findByUserName(String name);
    List<User> findByUserID(Long id);
    
    
}
