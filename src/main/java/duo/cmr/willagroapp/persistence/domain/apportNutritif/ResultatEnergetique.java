package duo.cmr.willagroapp.persistence.domain.apportNutritif;

public class ResultatEnergetique{
    final String nom;
    private final Double valeur;

    public ResultatEnergetique(Double valeur, String nom) {
        this.valeur = valeur;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    public Double getValeur() {
        return valeur;
    }

    public String getUnite() {
        return "%";
    }

    public String toString() {
        return "ResultatEnergetique{" +
               "nom='" + nom + '\'' +
               ", valeur=" + valeur +
               '}';
    }
}
