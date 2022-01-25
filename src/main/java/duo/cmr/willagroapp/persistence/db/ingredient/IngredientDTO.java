package duo.cmr.willagroapp.persistence.db.ingredient;

import duo.cmr.willagroapp.persistence.domain.entitees.Ingredient;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("ingredient")
public class IngredientDTO {
    @Id
    private Long id;
    private String name;
    private Double lysine;
    private Double methyonine;
    private Double proteineBrute;
    private Double energieMetabolisable;

    public IngredientDTO(String name, Double lysine, Double methyonine, Double proteineBrute, Double energieMetabolisable) {
        this.name = name;
        this.lysine = lysine;
        this.methyonine = methyonine;
        this.proteineBrute = proteineBrute;
        this.energieMetabolisable = energieMetabolisable;
    }

    @Id
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Double lysine() {
        return lysine;
    }

    public Double methyonine() {
        return methyonine;
    }

    public Double proteineBrute() {
        return proteineBrute;
    }

    public Double energieMetabolisable() {
        return energieMetabolisable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (IngredientDTO) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name) &&
               Objects.equals(this.lysine, that.lysine) &&
               Objects.equals(this.methyonine, that.methyonine) &&
               Objects.equals(this.proteineBrute, that.proteineBrute) &&
               Objects.equals(this.energieMetabolisable, that.energieMetabolisable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lysine, methyonine, proteineBrute, energieMetabolisable);
    }

    @Override
    public String toString() {
        return "IngredientDTO[" +
               "id=" + id + ", " +
               "name=" + name + ", " +
               "lysine=" + lysine + ", " +
               "methyonine=" + methyonine + ", " +
               "proteineBrute=" + proteineBrute + ", " +
               "energieMetabolisable=" + energieMetabolisable + ']';
    }

    public Ingredient toIngredient() {
        return new Ingredient(name, lysine, methyonine, proteineBrute, energieMetabolisable);
    }
}
