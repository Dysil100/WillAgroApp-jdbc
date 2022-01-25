package duo.cmr.willagroapp.persistence.db.standard;

import duo.cmr.willagroapp.persistence.domain.entitees.Standard;
import duo.cmr.willagroapp.service.repositories.StandardRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: 22.01.22 Implement a toStandard method
@Repository
public class StandardRepositoryImpl implements StandardRepository {

    final StandardDAO standardDAO;

    public StandardRepositoryImpl(StandardDAO standardDAO) {
        this.standardDAO = standardDAO;
    }

    @Override
    public Standard findByDescription(String description) {
        return standardDAO.findByDescription(description).orElse(getOther()).toStandard(); // TODO: 22.01.22 Implements these methods
    }

    private StandardDTO getOther() {
        return new StandardDTO("Not Found", .0, .0, .0, .0);
    }

    @Override
    public Standard findById(Long id) {
        standardDAO.findById(id).orElse(getOther()).toStandard();
        return null;
    }

    @Override
    public void save(Standard standard) {
        standardDAO.save(new StandardDTO(standard.description(), standard.lysine().getValeur(),
                standard.methyonine().getValeur(), standard.proteineBrute().getValeur(), standard.energieMethabolisable().getValeur()));
    }

    @Override
    public void delete(Standard standard) {
        Optional<StandardDTO> byDescription = standardDAO.findByDescription(standard.description());
        byDescription.ifPresent(standardDAO::delete);
    }

    @Override
    public List<Standard> alle() {
        Iterable<StandardDTO> all = standardDAO.findAll();
        List<Standard> alle = new ArrayList<>();
        all.forEach(s -> alle.add(s.toStandard()));
        return alle;
    }
}
