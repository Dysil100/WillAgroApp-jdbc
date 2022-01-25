package duo.cmr.willagroapp.persistence.domain.entitees;

import duo.cmr.willagroapp.persistence.domain.apportNutritif.EnergieMethabolisable;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.Lysine;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.Methyonine;
import duo.cmr.willagroapp.persistence.domain.apportNutritif.ProteineBrute;

public record Standard(String description, Lysine lysine, Methyonine methyonine, ProteineBrute proteineBrute,
                       EnergieMethabolisable energieMethabolisable) {
}
