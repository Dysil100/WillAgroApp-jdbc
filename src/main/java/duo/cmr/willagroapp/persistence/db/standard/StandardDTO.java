package duo.cmr.willagroapp.persistence.db.standard;

import duo.cmr.willagroapp.persistence.domain.apportNutritif.EnergieMethabolisable;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.Lysine;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.Methyonine;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.ProteineBrute;
import duo.cmr.willagroapp.persistence.domain.entitees.Standard;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("standard")
public class StandardDTO {
    @Id
    private Long id;
    private String description;
    private Double lysine;
    private Double methyonine;
    private Double proteineBrute;
    private Double energieMetabolisable;

    public StandardDTO(String description, Double lysine, Double methyonine, Double proteineBrute, Double energieMetabolisable) {
        this.description = description;
        this.lysine = lysine;
        this.methyonine = methyonine;
        this.proteineBrute = proteineBrute;
        this.energieMetabolisable = energieMetabolisable;
    }

    @Id
    public Long id() {
        return id;
    }

    public String description() {
        return description;
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
        var that = (StandardDTO) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.description, that.description) &&
               Objects.equals(this.lysine, that.lysine) &&
               Objects.equals(this.methyonine, that.methyonine) &&
               Objects.equals(this.proteineBrute, that.proteineBrute) &&
               Objects.equals(this.energieMetabolisable, that.energieMetabolisable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, lysine, methyonine, proteineBrute, energieMetabolisable);
    }

    @Override
    public String toString() {
        return "StandardDTO[" +
               "id=" + id + ", " +
               "description=" + description + ", " +
               "lysine=" + lysine + ", " +
               "methyonine=" + methyonine + ", " +
               "proteineBrute=" + proteineBrute + ", " +
               "energieMetabolisable=" + energieMetabolisable + ']';
    }

    public Standard toStandard() {
        return new Standard(description, new Lysine(lysine), new Methyonine(methyonine),
                new ProteineBrute(proteineBrute), new EnergieMethabolisable(energieMetabolisable));
    }
}
