package fr.caos.metier;



import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class SessionUV_M {
    private String idSessionUV;
    private TypeSession_M typeUV;
    private List<String> date;
    private List<Candidature_M> list_candidatures;



    // constructor with parameters
    public SessionUV_M(TypeSession_M unTypeUV, String uneDate) {

        this.idSessionUV = Integer.toHexString(this.hashCode());
        this.typeUV = unTypeUV;
        this.date = new ArrayList<>();
        this.date.add(uneDate);
        this.list_candidatures = new ArrayList<>();
    }

    // constructor without parameters
    public SessionUV_M() {
        super();
    }



    // ajouter une date à la liste de dates
    public void addDate(String uneDate){
        this.date.add(uneDate);
    }

    // renvoie la liste des candidatures de la session
    public List<Candidature_M> getList_candidatures() {
        return list_candidatures;
    }

    // Ajoute une candidature à la liste des candidatures existantes pour la session
    public void addCandidature(Candidature_M uneCandidature){
        this.list_candidatures.add(uneCandidature);
    }

    // Setters et getters sur les autres attributs

    public String getIdSessionUV() {
        return idSessionUV;
    }

    public void setIdSessionUV(String idSessionUV) {
        this.idSessionUV = idSessionUV;
    }


    public TypeSession_M getTypeUV() {
        return typeUV;
    }

    public void setTypeUV(TypeSession_M typeUV) {
        this.typeUV = typeUV;
    }

    public String getIntituleSessionUV(){
        return this.getTypeUV().getIntitule();
    }

    public List<String> getDates(){
        return this.date;
    }

    //Methode pour retourner une SessionUV_M à partir de son idSession


}






