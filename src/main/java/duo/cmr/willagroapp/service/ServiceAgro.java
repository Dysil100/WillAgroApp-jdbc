package duo.cmr.willagroapp.service;

import duo.cmr.willagroapp.persistence.domain.apportNutritif.*;
import duo.cmr.willagroapp.persistence.domain.entitees.Ingredient;
import duo.cmr.willagroapp.persistence.domain.entitees.Standard;
import duo.cmr.willagroapp.service.repositories.IngredientRepository;
import duo.cmr.willagroapp.service.repositories.PersonRepository;
import duo.cmr.willagroapp.service.repositories.StandardRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class ServiceAgro {
    private Formular form;
    private List<Standard> standards;
    private HashMap<String, Standard> mapStandards;

    PersonRepository personRepository;
    IngredientRepository ingredientRepository;
    StandardRepository standardRepository;

    public ServiceAgro(PersonRepository personRepository, IngredientRepository ingredientRepository, StandardRepository standardRepository) {
        this.personRepository = personRepository;
        this.ingredientRepository = ingredientRepository;
        this.standardRepository = standardRepository;

        form = new Formular();
        standards = standardRepository.alle();
        initMapStandards();
        form.setTypes(mapStandards.keySet());
    }

    public void calculAnalytique(){
        form.setResultats(resultats());
        form.setResultatsStandards(resultatsStandards());
    }

    private void initMapStandards() {
        standards.forEach(s -> mapStandards.put(s.description(), s));
    }

    public Set<ResultatEnergetique> resultatsStandards() {
        Standard s = mapStandards.get(form.getType());
        return Set.of(s.lysine(), s.methyonine(), s.proteineBrute(), s.energieMethabolisable());
    }

    public Formular getForm() {
        return this.form;
    }

    public List<ResultatEnergetique> resultats() {
        Double summe1 = form.summe();
        Double summe = summe1 <= 0 ? 1 : summe1; //afin que le denominateur ne soit jamais null (pour eviter tout operation illegal)
        List<Ingredient> ingredients = getIngredients(); // la methode getIngreients est tres chers
        Double lysineTotal = ingredients.stream().map(ing -> ing.valeur() * ing.lysine() / (summe)).reduce(Double::sum).orElse(.0);
        Double methionineTotal = ingredients.stream().map(ing -> ing.valeur() * ing.methyonine() / (summe)).reduce(Double::sum).orElse(.0);
        Double proteineBruteTotal = ingredients.stream().map(ing -> ing.valeur() * ing.proteineBrute() / (summe)).reduce(Double::sum).orElse(.0);
        Double energieMetabolisable = ingredients.stream().map(ing -> ing.valeur() * ing.energieMetabolisable() / (summe)).reduce(Double::sum).orElse(.0);

        return List.of(new Lysine(lysineTotal), new Methyonine(methionineTotal),
                new ProteineBrute(proteineBruteTotal), new EnergieMethabolisable(energieMetabolisable));
    }

    // TODO: 22.01.22 Database umstrukturieren damit die Daten vernünftiger geladen werden
    private List<Ingredient> getIngredients() {
        Ingredient tourteau_de_coton = ingredientRepository.findByName("tourteau de coton");
        tourteau_de_coton.setValeur(form.getTourteauDeCoton());

        Ingredient belgofoxs = ingredientRepository.findByName("belgofoxs");
        belgofoxs.setValeur(form.getBelgofoxs());

        Ingredient belgoporcs = ingredientRepository.findByName("belgoporcs");
        belgoporcs.setValeur(form.getBelgoPorcs());

        Ingredient belgotox = ingredientRepository.findByName("belgotox");
        belgotox.setValeur(form.getBelgotox());

        Ingredient coquille_de_mer = ingredientRepository.findByName("coquille de mer");
        coquille_de_mer.setValeur(form.getCoquilleDeMer());

        Ingredient farine_de_soja = ingredientRepository.findByName("farine de soja");
        farine_de_soja.setValeur(form.getFarineDeSoja());

        Ingredient son_de_ble = ingredientRepository.findByName("son de blé");
        son_de_ble.setValeur(form.getSonDeBle());

        Ingredient sulfate_de_fer = ingredientRepository.findByName("sulfate de fer");
        sulfate_de_fer.setValeur(form.getSulfateDeFer());

        Ingredient tourteau_darachide = ingredientRepository.findByName("tourteau d`arachide");
        tourteau_darachide.setValeur(form.getTourteauDarachide());

        Ingredient tourteau_de_palmiste = ingredientRepository.findByName("tourteau de palmiste");
        tourteau_de_palmiste.setValeur(form.getTourteauDePalmiste());

        Ingredient mais = ingredientRepository.findByName("mais");
        mais.setValeur(form.getMais());

        Ingredient farine_de_poisson = ingredientRepository.findByName("farine de poisson");
        farine_de_poisson.setValeur(form.getFarineDePoisson());

        return List.of(farine_de_soja, farine_de_poisson, mais, belgofoxs, belgoporcs, belgotox,
                tourteau_darachide, tourteau_de_palmiste, tourteau_de_coton, coquille_de_mer, sulfate_de_fer, son_de_ble);
    }
}
