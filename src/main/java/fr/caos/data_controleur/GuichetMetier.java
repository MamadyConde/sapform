package fr.caos.data;


import java.util.*;

import javax.inject.Singleton;

import fr.caos.metier.Agent_M;
import fr.caos.metier.Candidature_M;
import fr.caos.metier.SessionUV_M;
import fr.caos.metier.TypeSession_M;
import fr.coas.dto.Agent;
import fr.coas.dto.Candidature;
import fr.coas.dto.TypeUV;


@Singleton

// La classe GuichetMetier implemente l'interface Metier_I
public class GuichetMetier{
    private static GuichetMetier guichetmetier;
    // pour être utilisé cette classe utilise nécéssairement une instance de sa propre classe
    private List<Agent_M> globale_list_agents;
    private List<Candidature_M> globale_list_candidatures;
    private List<SessionUV_M> globale_list_sessionUV;
    private List<TypeSession_M> globale_list_type_session;
    private static Map<String, Agent_M> list_couple_SID_Agent_M;
    private List<Agent> malistagents;




    // Constructeur dédié aux tests, initialise le Guichetmetier avec des valeurs dans les différentes listes
    public GuichetMetier(){
        this.globale_list_agents = new ArrayList<Agent_M>();
        this.globale_list_type_session = new ArrayList<TypeSession_M>();
        this.globale_list_sessionUV = new ArrayList<SessionUV_M>();
        this.globale_list_candidatures = new ArrayList<Candidature_M>();
        this.list_couple_SID_Agent_M = new HashMap<String, Agent_M>();
        this.malistagents = new ArrayList<>();

        malistagents.add(new Agent("123HH77", "BERNARD", "BERN001", "monpass01", false));
        malistagents.add(new Agent("123HU78", "MINET", "MINE001", "monpass01", false));
        malistagents.add(new Agent("333HA77", "CORBIER", "CORB001", "monpass01", false));

        TypeSession_M TypeSessEx01 = new TypeSession_M("Initiation lance à eau", 15, 5);
        TypeSession_M TypeSessEx02 = new TypeSession_M("Monter à la grande échelle", 20, 3);
        TypeSession_M TypeSessEx03 = new TypeSession_M("Traverser l'enfer", 20, 5);
        TypeSessEx03.addTypePrereq(TypeSessEx01);
        TypeSessEx03.addTypePrereq(TypeSessEx02);
        globale_list_type_session.add(TypeSessEx01);
        globale_list_type_session.add(TypeSessEx02);
        globale_list_type_session.add(TypeSessEx03);
        SessionUV_M sessionUV_M01 = new SessionUV_M(TypeSessEx01, "22-05-18");
        TypeSessEx01.addSessions(sessionUV_M01);
        globale_list_sessionUV.add(sessionUV_M01);
        SessionUV_M sessionUV_M02 = new SessionUV_M(TypeSessEx01, "12-06-18");
        TypeSessEx01.addSessions(sessionUV_M02 );
        globale_list_sessionUV.add(sessionUV_M02);
        SessionUV_M sessionUV_M03 = new SessionUV_M(TypeSessEx02, "09-04-18");
        TypeSessEx02.addSessions(sessionUV_M03);
        globale_list_sessionUV.add(sessionUV_M03);
        SessionUV_M sessionUV_M04 = new SessionUV_M(TypeSessEx02, "22-05-18");
        TypeSessEx02.addSessions(sessionUV_M04);
        globale_list_sessionUV.add(sessionUV_M04);
        SessionUV_M sessionUV_M05 = new SessionUV_M(TypeSessEx02, "15-06-18");
        TypeSessEx02.addSessions(sessionUV_M05);
        globale_list_sessionUV.add(sessionUV_M05);
        SessionUV_M sessionUV_M06 = new SessionUV_M(TypeSessEx03, "09-08-18");
        TypeSessEx03.addSessions(sessionUV_M06);
        globale_list_sessionUV.add(sessionUV_M06);

        Agent_M agent_M01 = new Agent_M( "BERGER", "BE0001", "mypassword001", false);
        Agent_M agent_M02 = new Agent_M( "MARTIN", "MA0001", "mypassword002", false);
        Agent_M agent_M03 = new Agent_M( "DUPONT", "DU0001", "mypassword003", false);
        Agent_M agent_M04 = new Agent_M( "GALL", "GA0001", "mypassword004", true);
        Agent_M agent_M05 = new Agent_M( "DUPONT", "DU0001", "mypassword005", false);
        Agent_M agent_M06 = new Agent_M( "NOHA", "NO0001", "mypassword006", false);
        Agent_M agent_M07 = new Agent_M( "ZIDANE", "ZI0001", "mypassword007", false);
        Agent_M agent_M08 = new Agent_M( "EVRA", "EV0001", "mypassword008", false);
        Agent_M agent_M09 = new Agent_M( "LEWIS", "LE0001", "mypassword009", false);
        globale_list_agents.add(agent_M01);
        globale_list_agents.add(agent_M02);
        globale_list_agents.add(agent_M03);
        globale_list_agents.add(agent_M04);
        globale_list_agents.add(agent_M05);
        globale_list_agents.add(agent_M06);
        globale_list_agents.add(agent_M07);
        globale_list_agents.add(agent_M08);
        globale_list_agents.add(agent_M09);
        Candidature_M candidature_M01 = new Candidature_M(agent_M01, sessionUV_M01, "Accepted", "Stagiaire", 0);
        Candidature_M candidature_M02 = new Candidature_M(agent_M01, sessionUV_M02, "Rejected", "Stagiaire", 0);
        Candidature_M candidature_M03 = new Candidature_M(agent_M02, sessionUV_M01, "Processing", "Stagiaire", 0);
        Candidature_M candidature_M04 = new Candidature_M(agent_M03, sessionUV_M03, "Accepted", "Formateur", 0);
        agent_M01.addCandidatures(candidature_M01);
        agent_M01.addCandidatures(candidature_M02);
        agent_M02.addCandidatures(candidature_M03);
        agent_M03.addCandidatures(candidature_M04);
        globale_list_candidatures.add(candidature_M01);
        globale_list_candidatures.add(candidature_M02);
        globale_list_candidatures.add(candidature_M03);
        globale_list_candidatures.add(candidature_M04);
        //list_couple_SID_Agent_M.put("124BZE", agent_M01);
       // list_couple_SID_Agent_M.put("233XVH", agent_M02);
        //list_couple_SID_Agent_M.put("444ABC", agent_M04);


    }

      public static GuichetMetier getGuichetMetier() {
              if (guichetmetier == null) {
                       guichetmetier = new GuichetMetier();
                  }
              return guichetmetier;
       }

    public static void setList_couple_SID_Agent_M(Map<String, Agent_M> list_couple_SID_Agent_M) {
        GuichetMetier.list_couple_SID_Agent_M = list_couple_SID_Agent_M;
    }

    public static Map<String,Agent_M> getList_couple_SID_Agent_M() {
        return list_couple_SID_Agent_M;
    }

    //Ce Getter permet aux différents managers d'appeler l'instance existante de la classe métier.
    //Si il n'existe pas d'instance de la classe Metier au moment de l'appelle, alors une instance est créée


    ////////////////////////// Ensemble des méthodes qui concernant les SessionsUV  ////////////////////////////////

    // Cette methode renvoie la liste des SessionsUV accessibles pour un agent donné (à partir du SID en paramètre)
    //@Override
    public List<SessionUV_M> getSessionsAccessibles(String SID){

        Agent_M agent;

        agent=this.getAgentFromSid(SID); //récupération de l'agent correspondant au sid



        List<SessionUV_M> resultat = new LinkedList<SessionUV_M>();//initialisation de la liste résultat



        for(TypeSession_M a:this.globale_list_type_session) {//pour chaque typeUV

            if(agent.getList_UV_achieved().containsAll(a.getList_typePrereq())) {// si les prérequis sont tous dans les aquis de l'agent

                resultat.addAll(a.getList_sessions());//ajout des sessionsUV du typeUV dans la liste

            }

        }

        return resultat;

    }

    // Methode qui renvoie une SessionUV_M (Métier) à partir de l'idSession
    //@Override
    public SessionUV_M getDetailsSession(String idSessionUV){

        boolean trouver =false;// session non encore trouvée

        ListIterator<SessionUV_M> listeLocale=globale_list_sessionUV.listIterator();//création d'un itérateur sur la liste des sessions

        SessionUV_M session=null;//initialisation de la session à retourner



        while(listeLocale.hasNext()&&!trouver) {//parcourt de la liste jusqu'à terminer la liste ou trouver la bonne session

            session = listeLocale.next();//récupération de la session suivante

            if(idSessionUV==session.getIdSessionUV()) {trouver=true;}//s'il s'agit de la bonne session alors on a trouvé et on sort de la boucle

        }



        if(!trouver) {session=null;} //si sortie de la boucle car fin de la liste alors on élimine la dernière valeure de session



        return session;//new SessionUV_M(new TypeSession_M("Stage de survie", 20, 3), "22-09-22");

    }

    // Methode pour récupérer la liste des candidatures à une SessionUV donnée
    //@Override
    public List<Candidature_M> getListCandidaturesPourUneSessionUV(String idSessionUV){
        boolean trouver =false;// SesionUV non encore trouvée

        ListIterator<SessionUV_M> listeLocale=this.globale_list_sessionUV.listIterator();//création d'un itérateur sur la liste des sessionsUV

        SessionUV_M session=null;//initialisation de la sessionUV pour laquelle on recherche la liste de candidatures à retourner

        while(listeLocale.hasNext()&&!trouver) {//parcourt de la liste jusqu'à terminer la liste ou trouver le bon agent

            session = listeLocale.next();//récupération de la sessionUV_M suivante suivant

            if(idSessionUV == session.getIdSessionUV()) {trouver=true;}//s'il s'agit de la bonne session alors on a trouvé et on sort de la boucle

        }

        if(!trouver) {session=null;} //si sortie de la boucle car fin de la liste alors on élimine la dernière valeure de session

        return session.getList_candidatures();

    }


    ////////////////////////// Ensemble des méthodes concernant les Candidatures  ////////////////////////////////

    // Methode pour créer une nouvelle candidature pour un Agent, à partir de SID, de l'idSession et qualité
    //@Override
    public Candidature_M createCandidature(String SID, String idSessionUV, String qualite){

        Agent_M agent=this.getAgentFromSid(SID);

        SessionUV_M session=this.getDetailsSession(idSessionUV);//récupération des paramètres



        Candidature_M cand= new Candidature_M( agent, session, "pending", qualite, 0);//création de la candidature

        //ajout de la candidature dans la liste de l'objet agent et session correspondant

        agent.addCandidatures(cand);

        session.addCandidature(cand);

        this.globale_list_candidatures.add(cand);

        return cand;

    }

    //Methode qui supprime une candidature à partir d'une Candidature (DTO) fournie en paramètre
    //@Override
    public boolean suppressCandidature(String idCandidature) {
        boolean deleted = false;
        List<Candidature> candidatures = new ArrayList<Candidature>();
        //Candidature_M candidatureM= null;
        for (Candidature_M cand : getListCandidatures_M()) {
            if (cand.getIdCandidature().equals(idCandidature)) {
                Candidature c = new Candidature(cand);
                candidatures.add(c);
                candidatures.remove(c);
                deleted = true;
                break;
            }
            /*if (candRemove != null) {
                getListCandidatures_M().remove(candRemove);
                deleted = true;
            }*/
        }
        return deleted;
    }


    //Methode pour mettre à jour une candidature (Accepter, refuser ou mettre en attente)
    //@Override
    public boolean updateCandidature(Candidature cand, String statut, String idCandidature, String idSessionUV) {
        boolean reponse = false;
        List<Candidature> candidature = new ArrayList<Candidature>();
        for (Candidature_M c : getListCandidatures_M()) {
            if (c.getSessionUV().getIdSessionUV().equals(idSessionUV)) {
                Candidature a = new Candidature(c);
                candidature.add(a);
                if (a.getIdCandidature().equals(idCandidature)) {
                    if (a.getStatut() == "En attente") {
                        a.setStatut("Accepter");
                        break;
                    } else if (a.getStatut() == "Processing") {
                        a.setStatut("En attente");
                        break;
                    }
                }
            }
        }
        return reponse;
    }


    //Methode pour changer la position d'une candidature dans la liste d'attente
    //@Override
    public int updateCandidaturePosition(Candidature uneCandidature, int position){
        Candidature_M Cand = getCandidature_M(uneCandidature);
        Cand.setPosition(position);
        return Cand.getPosition();
    }

    //Methode utilisée pour renvoyer la liste des candidatures d'un Agent à partir de son SID
    //@Override
    public List<Candidature_M> getListCandidatures_M(String SID){

        Agent_M agent=this.getAgentFromSid(SID);

        return agent.getCandidatures();

    }

    // Methode pour simplement renvoyer la liste globale des candidatures du système
    //@Override
    public List<Candidature_M> getListCandidatures_M(){
        return globale_list_candidatures;
    }

    // cette méthode permet de récupérer une Candidature_M à partir d'une Candidature(DTO)
    private Candidature_M getCandidature_M(Candidature cand_DTO) {

        Candidature_M cand=null;//initialisation de la candidature à retourner

        Agent_M agent =this.getAgentFromId(cand_DTO.getIdAgent());

        SessionUV_M session=this.getDetailsSession(cand_DTO.getIdSession());



        boolean trouver =false;// session non encore trouvée

        ListIterator<Candidature_M> listeLocale=this.globale_list_candidatures.listIterator();//création d'un itérateur sur la liste des candidatures



        while(listeLocale.hasNext()&&!trouver) {//parcourt de la liste jusqu'à terminer la liste ou trouver la bonne candidature

            cand = listeLocale.next();//récupération de la candidature suivante

            if(agent==cand.getAgent()&&session==cand.getSessionUV()) {trouver=true;}//s'il s'agit de la bonne session alors on a trouvé et on sort de la boucle

        }



        if(!trouver) {cand=null;}



        return cand;

    }

    //@Override
    public boolean verifGestionnaire(Agent_M a) {
        boolean reponse = false;
        for (Agent_M agent : getGlobale_list_agents()) {
        	
            if (agent.isGestionnaire()) {
            	
                reponse = true;
                break;
            }
        }
        return reponse;
    }




    ////////////////////////// Ensemble des méthodes qui concernant les Agents ////////////////////////////////


    //Cette fonction renvoie la liste contenant l'ensemble des objets Agent_M existant
    //@Override
    public List<Agent_M> getGlobale_list_agents(){
        return globale_list_agents;
    }

    // Cette méthode renvoie un Agent_M à partir d'un SID
    //@Override
    public Agent_M getAgentFromSid(String SID){

        Agent_M agent;

        agent=this.list_couple_SID_Agent_M.getOrDefault(SID, null);

        return agent;

    }

    // Cette méthode permet de récupérer un Agent_M à partir de son idAgent
    private Agent_M getAgentFromId(String idAgent) {

        boolean trouver =false;// agent non encore trouvée

        ListIterator<Agent_M> listeLocale=this.globale_list_agents.listIterator();//création d'un itérateur sur la liste des agents

        Agent_M agent=null;//initialisation de l'agent à retourner



        while(listeLocale.hasNext()&&!trouver) {//parcourt de la liste jusqu'à terminer la liste ou trouver le bon agent

            agent = listeLocale.next();//récupération de l'agent suivant

            if(idAgent==agent.getIdAgent()) {trouver=true;}//s'il s'agit du bon agent alors on a trouvé et on sort de la boucle

        }



        if(!trouver) {agent=null;} //si sortie de la boucle car fin de la liste alors on élimine la dernière valeure de session



        return agent;

    }

    //Methode pour renvoyer les TypeSession accomplies pour un agent
    //@Override
    public List<TypeSession_M> getTypeSessionAchieved(String SID){
        Agent_M agent=this.getAgentFromSid(SID);
        return agent.getList_UV_achieved();
    }

    //Methode pour savoir si un agent est authorisé à candidater en tant que formateur
    //@Override
    public boolean isAuthorizedAsFormer(Agent_M unAgent, SessionUV_M uneSession){
        if (unAgent.getList_UV_achieved().contains(uneSession.getTypeUV())){
            return true;
        }
        return false;
    }






    ////////////////////////// Ensemble des méthodes qui concernant la connexion  ////////////////////////////////

    // Méthode qui vérifie si un Agent est connecté (vérifie si le SID en paramètre est bien présent dans la hashmap)
    //@Override
    public boolean estConnexion(String Sid) {
        return this.list_couple_SID_Agent_M.containsKey(Sid);

    }


    // Ajoute un couple SID Agent_M à la map "list_couple_SID_Agent_M"
    //@Override
    public void ajouteSID_Agent_M(String sid, Agent_M unAgent_M) {

        getList_couple_SID_Agent_M().put(sid, unAgent_M);
    }

    // TODO Cette méthode permet de renvoyer l'Agent_M de la map à partir de son SID, retourne null si pas dans la map
    // TODO cette méthode est-elle utile ?
    //@Override
    public Agent_M check_SID_Agent_M(String SID){
        return this.list_couple_SID_Agent_M.get(SID);
    }
///////////////////////////////////////////////////:TOUTES MES METHODES DE PEUPLEMENT DE BASE////////////////////////////////////////

    //@Override
    public Agent_M createAgent(Agent unAgent){
        String nom = unAgent.getNom();
        String login = unAgent.getLogin();
        String mdp = unAgent.getPassword();
        boolean gestionanire = unAgent.isGestionnaire();

        Agent_M newAgent_M = new Agent_M(nom, login, mdp, gestionanire);
        globale_list_agents.add(newAgent_M);
        return newAgent_M;
    }

    //@Override
    public TypeSession_M createTypeSession(TypeUV unTypeUV){
        String intitule = unTypeUV.getNomTypeUV();
        int effmin = unTypeUV.getEffectifMin();
        int effmax = unTypeUV.getEffectifMax();
        TypeSession_M nouveauTypeSession = new TypeSession_M(intitule, effmax, effmin);
        globale_list_type_session.add(nouveauTypeSession);
        return nouveauTypeSession;
    }

    //@Override
    public List<TypeSession_M> getGlobale_list_type_session(){
        return globale_list_type_session;
    }

    //@Override
    public List<SessionUV_M> getGlobale_list_sessionUV(){
        return globale_list_sessionUV;
    }

    //@Override
    public Agent_M agentexist(String login, String mdp){

        for (Agent_M a : globale_list_agents) {
            if (a.getLogin().equals(login) && a.getPassword().equals(mdp)) {
                return a;
            }
        }

        return null;
    }

    //@Override
    public Map<String, Agent_M> getCoupleSID_Agent(){
        return list_couple_SID_Agent_M;
    }

    // Ensemble de méthode qui permettent de créer un objet DTO à partir de son objet Métier

    // renvoie una Candidature DTO à partir d'une Candidature Metier
    //@Override
    public Candidature candConverter(Candidature_M uneCandMetier){
        String idCandidature = uneCandMetier.getIdCandidature();
        String idAgent = uneCandMetier.getAgent().getIdAgent();
        String idSessionUV = uneCandMetier.getSessionUV().getIdSessionUV();
        String statut = uneCandMetier.getStatut();
        String qualite = uneCandMetier.getQualite();
        int position = uneCandMetier.getPosition();

        return new Candidature(idCandidature, idAgent, idSessionUV, statut, qualite, position);
    }

    public static void setList_couple_SID_Agent_M(String sid, Agent_M a) {
        getList_couple_SID_Agent_M().put(sid, a);
    }
}
