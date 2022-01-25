package duo.cmr.willagroapp.service.repositories;

import duo.cmr.willagroapp.persistence.domain.entitees.Ingredient;

public interface IngredientRepository {
     Ingredient findByName(String name);
     Ingredient findById(Long id);
     void save(Ingredient ingredient);
     void delete(Ingredient ingredient);
}
