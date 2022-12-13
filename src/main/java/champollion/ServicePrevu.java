package champollion;

public class ServicePrevu {
    private UE ue;
    private Enseignant ensaignant;
    private int volumeCM ;
    private int volumeTD;
    private int volumeTP;


    public ServicePrevu(UE ue, Enseignant ensaignant, int volumeCM, int volumeTD, int volumeTP) {
        this.ue = ue;
        this.ensaignant = ensaignant;
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public int getvolumeCM(){
    return volumeCM;
}
    public int getvolumeTD(){
        return volumeTD;
    }
    public int getvolumeTP(){
        return volumeTP;
    }
    public void setVolumeCM(int newCM){
    this.volumeCM=newCM;
}
    public void setVolumeTD(int newTD){
        this.volumeCM=newTD;
    }
    public void setVolumeTP(int newTP){
        this.volumeCM=newTP;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getEnsaignant() {
        return ensaignant;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setEnsaignant(Enseignant ensaignant) {
        this.ensaignant = ensaignant;
    }
}
