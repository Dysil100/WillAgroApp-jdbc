package duo.cmr.willagroapp.persistence.db.ingredient;

import duo.cmr.willagroapp.persistence.domain.entitees.Ingredient;
import duo.cmr.willagroapp.service.repositories.IngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO: 22.01.22 Implement a toIngredient method
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    final
    IngredientDAO ingredientDAO;

    public IngredientRepositoryImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientDAO.findByName(name).orElse(getOther()).toIngredient(); // TODO: 22.01.22 implements all methods
    }

    private IngredientDTO getOther() {
        return new IngredientDTO("Not Found", .0, .0, .0, .0);
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientDAO.findById(id).orElse(getOther()).toIngredient();
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientDAO.save(new IngredientDTO(ingredient.name(), ingredient.lysine(), ingredient.methyonine(),
                ingredient.proteineBrute(), ingredient.energieMetabolisable()));
    }

    @Override
    public void delete(Ingredient ingredient) {
        Optional<IngredientDTO> byName = ingredientDAO.findByName(ingredient.name());
        byName.ifPresent(ingredientDAO::delete);

    }
}
