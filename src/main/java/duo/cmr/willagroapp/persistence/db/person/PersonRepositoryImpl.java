package duo.cmr.willagroapp.persistence.db.person;

import duo.cmr.willagroapp.persistence.domain.entitees.Person;
import duo.cmr.willagroapp.service.repositories.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO: 22.01.22 Implement a toperson method
@Repository
public class PersonRepositoryImpl implements PersonRepository {
    final
    PersonDAO personDAO;

    public PersonRepositoryImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public Person findByName(String name) {
        return personDAO.findByName(name).orElse(getOther()).toPerson();
    }

    @Override
    public Person findById(Long id) {
        return personDAO.findById(id).orElse(getOther()).toPerson();
    }

    private PersonDTO getOther() {
        return new PersonDTO("Not  Found", "not found", "not found");
    }

    @Override
    public void save(Person person) {
        personDAO.save(new PersonDTO(person.name(), person.email(), person.telephone()));
    }

    @Override
    public void delete(Person person) {
        Optional<PersonDTO> byName = personDAO.findByName(person.name());
        byName.ifPresent(personDAO::delete);
    }
}
