package fr.caos.metier;


public class Candidature_M {

    private String idCandidature;
    private Agent_M agent;
    private SessionUV_M sessionUV;
    private String statutCandidature;
    private String qualite;
    private int position;

    // Constructeur avec paramètres
    public Candidature_M(Agent_M agent, SessionUV_M session, String statut, String qualite, int position) {
        this.idCandidature = Integer.toHexString(this.hashCode());
        this.agent = agent;
        this.sessionUV = session;
        this.statutCandidature = statut;
        this.qualite = qualite;
        this.position = position;
    }

    // Constructeur sans paramètres
    public Candidature_M(){
        super();
    }

    // Ensemble de getters et setters pour les attributs
    public String getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(String idCandidature) {
        this.idCandidature = idCandidature;
    }

    public Agent_M getAgent() {
        return agent;
    }

    public void setAgent(Agent_M agent) {
        this.agent = agent;
    }

    public SessionUV_M getSessionUV() {
        return sessionUV;
    }

    public void setSessionUV(SessionUV_M session) {
        this.sessionUV = session;
    }

    public String getStatut() {
        return statutCandidature;
    }

    public void setStatutCandidature(String statut) {
        this.statutCandidature = statut;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


