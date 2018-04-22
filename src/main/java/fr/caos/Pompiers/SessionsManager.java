package fr.caos.Pompiers;


import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.caos.data.GuichetMetier;
import fr.caos.metier.Agent_M;
import fr.caos.metier.Candidature_M;
import fr.caos.metier.SessionUV_M;
import fr.coas.dto.Candidature;
import fr.coas.dto.SessionUV;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Viviane Hounkanrin
 */
@Singleton
@Path("{sid}/sessions")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SessionsManager {
    private List<SessionUV_M> sessionList;
    private GuichetMetier managerMetier = new GuichetMetier();


    // Retourne la liste des SessionsUV accessible pour l'agent en fonction du SID
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public synchronized List<SessionUV> getSessionList(@PathParam("sid") String sid, @Context HttpServletRequest request) {
        List<SessionUV> sessionUV_list = new ArrayList<SessionUV>();
        HttpSession sessionInformatique = request.getSession();
        //verification de la connexion
        if (sessionInformatique.getId().substring(0, 4).equals(sid.substring(0, 4))) {
            List<SessionUV_M> authorized_sessions = managerMetier.getSessionsAccessibles(sid);
            for (int i = 0; i < authorized_sessions.size(); i++){
                String idSession = authorized_sessions.get(i).getIdSessionUV();
                String intitule = authorized_sessions.get(i).getIntituleSessionUV();
                String typeUV = authorized_sessions.get(i).getTypeUV().getIntitule();
                List<String> date = authorized_sessions.get(i).getDates();

                sessionUV_list.add(new SessionUV(idSession, intitule, typeUV, date));
            }
            return sessionUV_list;
        }
        return null;
    }

    //Renvoie les détails d'une SessionUV en fonction de l'idSession envoyé
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{idSessionUV}")
    public synchronized SessionUV getSessionsDetails(@PathParam("sid") String sid, @PathParam("idSessionUV") String idSessionUV, @Context HttpServletRequest request) {
        //recuperation de la session
        HttpSession sessionInformatique2 = request.getSession();
        // verification si l'agent vraiment connecté
        if (sessionInformatique2.getId().substring(0, 4).equals(sid.substring(0, 4))) {
            //GuichetMetier managerMetier = GuichetMetier.getGuichetMetier();
            SessionUV sessionD = new SessionUV(managerMetier.getDetailsSession(idSessionUV));

            return sessionD;
        }
        return null;
    }

    // Pour candidater à une session -> controles préalables de la possibilité ou non de candidater en tant que gestionnaire
    @POST
    @Path("/candidature")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public synchronized Candidature addCandidature(@PathParam("sid") String sid, Candidature uneCand, @Context HttpServletRequest request) {

        //recuperation de la session
        HttpSession sessionInformatique = request.getSession();
        // verification si l'agent vraiment connecté
        if (sessionInformatique.getId().equals(sid)) {
            //GuichetMetier managerMetier = GuichetMetier.getGuichetMetier();
            // Vérification que l'agent a bien le droit de candidater à la session ciblée
            List<SessionUV_M> sessionsAccessibles = managerMetier.getSessionsAccessibles(sid);
            List<String> id_des_sessions_accessibles = new ArrayList<>(); // on créé une liste qui va contenir les idSession des Sessions accessibles pour l'agent
            for (int i = 0; i < sessionsAccessibles.size(); i++) {
                String idSession = sessionsAccessibles.get(i).getIdSessionUV();
                id_des_sessions_accessibles.add(idSession);
            }

            if (id_des_sessions_accessibles.contains(uneCand.getIdSession())){
                // Si qualité est "stagiaire" alors on créé la candidature, si c'est formateur, on vérifie qu'il peut être formateur
                // sur la session avant de créer la candidature
                if (uneCand.getQualite().equals("stagiaire")){
                    Candidature newCand = managerMetier.candConverter(managerMetier.createCandidature(sid,uneCand.getIdSession(), uneCand.getQualite()));
                    return newCand;

                } else if (uneCand.getQualite().equals("formateur")){
                    Agent_M candidat = managerMetier.getAgentFromSid(sid);
                    SessionUV_M sessionCible = managerMetier.getDetailsSession(uneCand.getIdSession());
                    if (managerMetier.isAuthorizedAsFormer(candidat, sessionCible)){  // test de vérif si le candidat est authisé en tant que formateur sur la session
                        Candidature_M nouvCand = managerMetier.createCandidature(sid,uneCand.getIdSession(), uneCand.getQualite());
                        Candidature newCand = managerMetier.candConverter(nouvCand);
                        return newCand;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }


    @GET
    @Produces("text/plain")
    @Path("/idsess_info")
    public synchronized String getSessions_id_Informatique(@Context HttpServletRequest request) {
        //recuperation de la session
        HttpSession sessionInformatique = request.getSession();
        return sessionInformatique.getId();
    }

   

}







