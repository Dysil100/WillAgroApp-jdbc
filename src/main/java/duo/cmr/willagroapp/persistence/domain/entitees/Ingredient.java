package duo.cmr.willagroapp.persistence.domain.entitees;

public record Ingredient(String name, Double lysine, Double methyonine, Double proteineBrute,
                         Double energieMetabolisable) {
    public static double valeur;
    public Double valeur(){return valeur;}
    public void setValeur(Double valeur1){
        valeur = valeur1;
    }
}
