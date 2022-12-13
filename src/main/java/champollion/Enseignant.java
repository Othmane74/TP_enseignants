package champollion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static java.lang.Math.round;

public class Enseignant extends Personne {

    private List<ServicePrevu> enseignements;

    private List<Intervention> interventionsP;


    public Enseignant(String nom, String email) {

        super(nom, email);
        this.enseignements= new ArrayList<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
  public int heuresPrevues() {
    int nbtotal=0;
    for(ServicePrevu s: enseignements){
       nbtotal+= (int) round( s.getvolumeCM() * 1.5 + s.getvolumeTD() + s.getvolumeTP() * 0.75);
    }
    return round(nbtotal);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int nbtotal=0;
        for(ServicePrevu s: enseignements){
            if(s.getUe().equals(ue)) {
                nbtotal += (int) round( s.getvolumeCM() * 1.5 + s.getvolumeTD() + s.getvolumeTP() * 0.75);
            }
    }
        return round(nbtotal);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        this.enseignements.add(new ServicePrevu( ue,this,volumeCM,volumeTD,volumeTP));
    }

    public boolean enSousService(){
        boolean res= false;
        if(this.heuresPrevues()<192){
            return true;
        }
        return res;
    }
    public void ajouteIntervention(Intervention inter){
        this.interventionsP.add(inter);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) throws Exception {
        int totalIntervention = 0;
        EnumMap<TypeIntervention, Double> equivalentTD = new EnumMap<TypeIntervention, Double>(TypeIntervention.class);
        equivalentTD.put(TypeIntervention.CM, 1.5);
        equivalentTD.put(TypeIntervention.TD, 1.0);
        equivalentTD.put(TypeIntervention.CM, 0.75);
        for(Intervention intervention : interventionsP) {
            if (intervention.getMatiere().equals(ue) && intervention.getType() == type){
                totalIntervention += intervention.getDuree();
            }
        }
        if((heuresPrevuesPourUE(ue) - totalIntervention) < 0){
            throw new Exception("La durée totale des interventions est supérieure au total d'heures planifiés");
        }
        return (heuresPrevuesPourUE(ue) - totalIntervention);
    }




}
