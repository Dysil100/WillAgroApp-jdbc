package duo.cmr.willagroapp.persistence.domain.apportNutritif;

public class EnergieMethabolisable extends ResultatEnergetique {

    public EnergieMethabolisable(Double valeur) {
        super(valeur, "Energie Metabolique");
    }

    @Override
    public String getUnite(){
        return "KCal/Kg";
    }
}
