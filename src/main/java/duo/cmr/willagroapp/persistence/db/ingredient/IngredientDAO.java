package duo.cmr.willagroapp.persistence.db.ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IngredientDAO extends CrudRepository<IngredientDTO, Long> {
    Optional<IngredientDTO> findByName(String name);
}
