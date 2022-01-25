package duo.cmr.willagroapp.service.repositories;

import duo.cmr.willagroapp.persistence.domain.entitees.Person;

public interface PersonRepository {
    Person findByName(String name);
    Person findById(Long id);
    void save(Person person);
    void delete(Person person);
}
