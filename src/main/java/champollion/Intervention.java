package champollion;
import java.util.Date;

public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee =false;
    private int heureDebut;

    private Enseignant intervenant;
    private UE matiere;

    private TypeIntervention type;

    public Intervention(Date debut, int duree, int heureDebut, Enseignant intervenant, UE matiere, TypeIntervention type) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.intervenant = intervenant;
        this.matiere = matiere;
        this.type = type;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public int getHeureDebut() {
        return heureDebut;
    }


    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void Annuler(){
        this.annulee = true;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public TypeIntervention getType() {
        return type;
    }

    public UE getMatiere() {
        return matiere;
    }
}
