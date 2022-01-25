package duo.cmr.willagroapp.service.repositories;

import duo.cmr.willagroapp.persistence.domain.entitees.Standard;

import java.util.List;

public interface StandardRepository {
    Standard findByDescription(String name);
    Standard findById(Long id);
    void save(Standard standard);
    void delete(Standard standard);
    List<Standard> alle();
}
