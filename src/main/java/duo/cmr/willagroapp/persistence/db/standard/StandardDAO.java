package duo.cmr.willagroapp.persistence.db.standard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface StandardDAO extends CrudRepository<StandardDTO, Long> {
    Optional<StandardDTO> findByDescription(String description);
}
