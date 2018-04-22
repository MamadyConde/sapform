package fr.coas.dto;

import javax.xml.bind.annotation.XmlRootElement;

import fr.caos.metier.Candidature_M;

/**
 * @author YANNICK
 * @date 23 févr. 2018
 * @version 1.0.0
 *
 */

@XmlRootElement(name="candidature") //for Jersey

public class Candidature {

    private String idAgent;
    private String idSessionUV;
    private String statut;
    private String qualite;
    private int position;
    private String idCandidature;

    //explicit constructor required by the JAX-RS system
    public Candidature() {}

    //constructor
    public Candidature(String idCandidature, String idAgent, String idSessionUV, String statut, String qualite, int position){
        this.idCandidature=idCandidature;
        this.idAgent = idAgent;
        this.idSessionUV = idSessionUV;
        this.statut = statut;
        this.qualite = qualite;
        this.position = position;

    }

    // Second constructor wich turns a Candidature_M to a Candidature DTO - Quentin
    public Candidature(Candidature_M C){

        this.idAgent = C.getAgent().getIdAgent();
        this.idSessionUV = C.getSessionUV().getIdSessionUV();
        this.statut = C.getStatut();
        this.qualite = C.getQualite();
        this.position = C.getPosition();
        this.idCandidature=C.getIdCandidature();
    }

    //getters and setters
    /**
     * @return the idAgent
     */
    public String getIdAgent() {
        return idAgent;
    }

    /**
     * @param idAgent the idAgent to set
     */
    public void setIdAgent(String idAgent) {
        this.idAgent = idAgent;
    }

    /**
     * @return the idSession
     */
    public String getIdSession() {
        return idSessionUV;
    }

    /**
     * @param idSession the idSession to set
     */
    public void setIdSession(String idSession) {
        this.idSessionUV = idSession;
    }

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * @return the qualite
     */
    public String getQualite() {
        return qualite;
    }

    /**
     * @param qualite the qualite to set
     */
    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    public String getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(String idCandidature) {
        this.idCandidature = idCandidature;
    }
}

