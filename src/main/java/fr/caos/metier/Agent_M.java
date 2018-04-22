package fr.caos.metier;

import java.util.ArrayList;
import java.util.List;

public class Agent_M {
    private String idAgent;
    private String nom;
    private String login;
    private String password;
    private boolean gestionnaire;
    private List<TypeSession_M> list_UV_achieved; // liste des types d UV déjà validé par l'agent
    private List<Candidature_M> list_candidatures_encours; // liste des candidatures en cours de l'agent


    // Constructeur avec paramètres
    public Agent_M(String nom, String login, String password, boolean gestionnaire){
        this.idAgent = Integer.toHexString(this.hashCode());
        this.nom = nom;
        this.login= login;
        this.password = password;
        this.gestionnaire = gestionnaire;
        this.list_UV_achieved = new ArrayList<TypeSession_M>();
        this.list_candidatures_encours = new ArrayList<Candidature_M>();
    }

    // Constructeur sans paramètres
    public Agent_M() {
        super();
    }

    // Retourne la liste des candidatures en cours
    public List<Candidature_M> getCandidatures() {
        return list_candidatures_encours;
    }

    // Ajoute une candidature à la liste des candidatures
    public void addCandidatures(Candidature_M uneCandidature) {
        list_candidatures_encours.add(uneCandidature);
    }

    //Retourne la liste des types d UV validée par l'agent
    public List<TypeSession_M> getList_UV_achieved() {
        return list_UV_achieved;
    }

    // Ajoute un type d UV à la liste des UV validés par l'agent
    public void add_UV_achieved (TypeSession_M unTypeSession) {
        list_UV_achieved.add(unTypeSession);
    }

    // Getters et Setters pour le reste des attributs
    public String getIdAgent() {
        return idAgent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isGestionnaire() {
           return this.gestionnaire;

        }

    public void setGestionnaire(boolean gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

}
