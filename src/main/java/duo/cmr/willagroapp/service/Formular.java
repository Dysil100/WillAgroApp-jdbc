package duo.cmr.willagroapp.service;

import duo.cmr.willagroapp.persistence.domain.apportNutritif.ResultatEnergetique;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Formular {
    @NonNull
    private String type;
    @NonNull
    private Double mais;

    @NonNull
    private Double sonDeBle;
    @NonNull
    private Double farineDeSoja;
    @NonNull
    private Double farineDePoisson;
    @NonNull
    private Double tourteauDePalmiste;
    @NonNull
    private Double tourteauDeCoton;
    @NonNull
    private Double tourteauDarachide;
    @NonNull
    private Double sulfateDeFer;
    @NonNull
    private Double belgotox;
    @NonNull
    private Double belgofoxs;
    @NonNull
    private Double coquilleDeMer;
    @NonNull
    private Double belgoPorcs;
    boolean zeigen;
    private Set<String> types;
    private Set<ResultatEnergetique> resultatsStandards;


    public void setResultats(List<ResultatEnergetique> resultats) {
        this.resultats = resultats;
    }

    private List<ResultatEnergetique> resultats;

    public LocalDateTime dateActuel() {
        return LocalDateTime.now();
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }
    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }


    public List<ResultatEnergetique> getResultats(){
        return resultats;
    }

    public Formular() {
        this(.0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0);
    }

    public Formular(Double mais, Double sonDeBle, Double farineDeSoja, Double farineDePoisson, Double tourteauDePalmiste, Double tourteauDeCoton, Double tourteauDarachide, Double sulfateDeFer, Double belgotox, Double belgofoxs, Double coquilleDeMer, Double belgoPorcs) {
        this.mais = mais;
        this.sonDeBle = sonDeBle;
        this.farineDeSoja = farineDeSoja;
        this.farineDePoisson = farineDePoisson;
        this.tourteauDePalmiste = tourteauDePalmiste;
        this.tourteauDeCoton = tourteauDeCoton;
        this.tourteauDarachide = tourteauDarachide;
        this.sulfateDeFer = sulfateDeFer;
        this.belgotox = belgotox;
        this.belgofoxs = belgofoxs;
        this.coquilleDeMer = coquilleDeMer;
        this.belgoPorcs = belgoPorcs;
        this.zeigen = false;
        type = "Porcins: Prédémarrage Porc (de 5 à 10 Jours)";
        types = new HashSet<>();
        resultatsStandards = new HashSet<>();
        resultats = new ArrayList<>();
    }


    public Double summe() {
        return mais + sonDeBle + farineDeSoja + farineDePoisson + tourteauDePalmiste + tourteauDeCoton +
               tourteauDarachide + sulfateDeFer + belgotox + belgofoxs + belgoPorcs + coquilleDeMer;
    }

    @NonNull
    public Double getMais() {
        return mais;
    }

    public void setMais(@NonNull Double mais) {
        this.mais = mais;
    }

    @NonNull
    public Double getSonDeBle() {
        return sonDeBle;
    }

    public void setSonDeBle(@NonNull Double sonDeBle) {
        this.sonDeBle = sonDeBle;
    }

    @NonNull
    public Double getFarineDeSoja() {
        return farineDeSoja;
    }

    public void setFarineDeSoja(@NonNull Double farineDeSoja) {
        this.farineDeSoja = farineDeSoja;
    }

    @NonNull
    public Double getFarineDePoisson() {
        return farineDePoisson;
    }

    public void setFarineDePoisson(@NonNull Double farineDePoisson) {
        this.farineDePoisson = farineDePoisson;
    }

    @NonNull
    public Double getTourteauDePalmiste() {
        return tourteauDePalmiste;
    }

    public void setTourteauDePalmiste(@NonNull Double tourteauDePalmiste) {
        this.tourteauDePalmiste = tourteauDePalmiste;
    }

    @NonNull
    public Double getTourteauDeCoton() {
        return tourteauDeCoton;
    }

    public void setTourteauDeCoton(@NonNull Double tourteauDeCoton) {
        this.tourteauDeCoton = tourteauDeCoton;
    }

    @NonNull
    public Double getTourteauDarachide() {
        return tourteauDarachide;
    }

    public void setTourteauDarachide(@NonNull Double tourteauDarachide) {
        this.tourteauDarachide = tourteauDarachide;
    }

    @NonNull
    public Double getSulfateDeFer() {
        return sulfateDeFer;
    }

    public void setSulfateDeFer(@NonNull Double sulfateDeFer) {
        this.sulfateDeFer = sulfateDeFer;
    }

    @NonNull
    public Double getBelgotox() {
        return belgotox;
    }

    public void setBelgotox(@NonNull Double belgotox) {
        this.belgotox = belgotox;
    }

    @NonNull
    public Double getBelgofoxs() {
        return belgofoxs;
    }

    public void setBelgofoxs(@NonNull Double belgofoxs) {
        this.belgofoxs = belgofoxs;
    }

    @NonNull
    public Double getCoquilleDeMer() {
        return coquilleDeMer;
    }

    public void setCoquilleDeMer(@NonNull Double coquilleDeMer) {
        this.coquilleDeMer = coquilleDeMer;
    }

    @NonNull
    public Double getBelgoPorcs() {
        return belgoPorcs;
    }

    public void setBelgoPorcs(@NonNull Double belgoPorcs) {
        this.belgoPorcs = belgoPorcs;
    }

    public boolean isZeigen() {
        return zeigen;
    }

    public void setZeigen(boolean zeigen) {
        this.zeigen = zeigen;
    }

    @Override
    public String toString() {
        return "Formular{" +
               "mais=" + mais +
               ", sonDeBle=" + sonDeBle +
               ", farineDeSoja=" + farineDeSoja +
               ", farineDePoisson=" + farineDePoisson +
               ", tourteauDePalmiste=" + tourteauDePalmiste +
               ", tourteauDeCoton=" + tourteauDeCoton +
               ", tourteauDarachide=" + tourteauDarachide +
               ", sulfateDeFer=" + sulfateDeFer +
               ", belgotox=" + belgotox +
               ", belgofoxs=" + belgofoxs +
               ", coquilleDeMer=" + coquilleDeMer +
               ", belgoPorcs=" + belgoPorcs +
               ", zeigen=" + zeigen +
               '}';
    }

    public void setResultatsStandards(Set<ResultatEnergetique> resultatsStandards) {
     this.resultatsStandards = resultatsStandards;
    }
}