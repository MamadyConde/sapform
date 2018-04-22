package fr.coas.dto;
import javax.xml.bind.annotation.XmlRootElement;

import fr.caos.metier.Agent_M;

/**
 * @author YANNICK
 * @date 23 févr. 2018
 * @version 1.0.0
 *
 */

@XmlRootElement(name="agent") //for Jersey

public class Agent {

    private String idAgent;
    private String nom;
    private String login;
    private String password;
    private boolean gestionnaire;

    //explicit constructor required by the JAX-RS system
    public Agent() {}

    //constructor
    public Agent(String idAgent, String nom, String login, String password, boolean estGestionnaire) {
        this.idAgent = idAgent;
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.gestionnaire = estGestionnaire;
    }

    // Second constructor wich turns an Agent_M to a Agent DTO

    public Agent(Agent_M A){
        this.idAgent = A.getIdAgent();
        this.nom = A.getNom();
        this.login = A.getLogin();
        this.password = A.getPassword();
        this.gestionnaire =false;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estGestionnaire
     */
    public boolean isGestionnaire() {

            return this.gestionnaire;
    }

    /**
     * @param estGestionnaire the estGestionnaire to set
     */
    public void setGestionnaire(boolean estGestionnaire) {
        this.gestionnaire = estGestionnaire;
    }

}
