package duo.cmr.willagroapp.persistence.db.person;

import duo.cmr.willagroapp.persistence.domain.entitees.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PersonDAO extends CrudRepository<PersonDTO, Long> {
    /**
     * @param name
     * @return the entity coresponding to the provided name
     */
    Optional<PersonDTO> findByName(String name);
}
