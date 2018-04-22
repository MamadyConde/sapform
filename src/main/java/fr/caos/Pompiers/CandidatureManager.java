package fr.caos.Pompiers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.caos.data.GuichetMetier;
import fr.caos.metier.Agent_M;
import fr.caos.metier.Candidature_M;
import fr.coas.dto.Candidature;

@Singleton
@Path("{sid}/candidature")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

public class CandidatureManager {
    //List<Candidature> candidatures = new ArrayList<Candidature>();
    GuichetMetier guichetMetier = GuichetMetier.getGuichetMetier();
    /**
     * Default action for the candidature manager: return all candidature
     *
     * @return The list of candidature (all fields)
     * afficher toutes les candidatures(pour gestionnaires
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public synchronized List<Candidature> getCandidatureList(@PathParam("sid") String Sid) {
        //creation d'une liste DTO
        List<Candidature> candidatures = new ArrayList<Candidature>();
        
        // verification de la connexion de l'agent
        if (guichetMetier.estConnexion(Sid)) {
        	
            //on recupère l'agent
            Agent_M a = this.guichetMetier.check_SID_Agent_M(Sid);
           
            if (guichetMetier.verifGestionnaire(a)) {
                // parcours de la liste candidature_M
                System.out.println(guichetMetier.verifGestionnaire(a));
                for (Candidature_M candidatureM : guichetMetier.getListCandidatures_M()) {
                    Candidature cand = new Candidature(candidatureM);
                    candidatures.add(cand);
                }
                return candidatures;
            } 

        }
        return null;
    }

    /*
     * affiche la detail candidature d'un agent par idSession
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{idSessionUV}")
    public synchronized List<Candidature> getCandidatureByIdSession(@PathParam("sid") String sid, @PathParam("idSessionUV") String idSessionUV) {
        //creation d'une liste DTO
        List<Candidature> candidatureSession = new ArrayList<Candidature>();
        if (guichetMetier.estConnexion(sid)) {
            //on recupère l'agent
            Agent_M a = this.guichetMetier.check_SID_Agent_M(sid);
            if (guichetMetier.verifGestionnaire(a)) {
                // parcours de la liste candidature_M
                System.out.println(guichetMetier.verifGestionnaire(a));
                // parcours de la liste candidature_M
                for (Candidature_M candidatureM : guichetMetier.getListCandidatures_M()) {
                    if (candidatureM.getSessionUV().getIdSessionUV().equals(idSessionUV)) {
                        Candidature cand = new Candidature(candidatureM);
                        candidatureSession.add(cand);
                    }
                }
                return candidatureSession;
            }

        }
        return null;
    }

    /**
     * action Get candidature by idAgent
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/idAgent")
    public synchronized List<Candidature> getCandIdAgent(@PathParam("sid") String sid, @QueryParam("idAgent") String idAgent) {
        //creation d'une liste DTO
        List<Candidature> candidatureIdAgent = new ArrayList<Candidature>();
        if (guichetMetier.estConnexion(sid)) {
            // parcours de la liste candidature_M
            for (Candidature_M candidat : guichetMetier.getListCandidatures_M()) {
                if (candidat.getAgent().getIdAgent().equals(idAgent)) {
                    Candidature cand = new Candidature(candidat);
                    candidatureIdAgent.add(cand);
                   
                }
            }
            return candidatureIdAgent;
        }
        return null;
    }

    /**
     * action Put candidature
     */
    @DELETE
    @Path("{idcandidature}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces("text/plain")
    public synchronized String deleteCandidature(@PathParam("sid") String sid, @PathParam("idcandidature") String idCandidature) {
        //verifie si l'agent est connecté
        // if (guichetMetier.estConnexion(sid)) {
        
        boolean deleted = guichetMetier.suppressCandidature(idCandidature);
        if (deleted) {
            System.out.println("vivi");
            return " Votre Candidature " + idCandidature + " a été Supprimée";
        } else {
            System.out.println("vivi");
            return "Cette candidature n'existe pas";
        }


    }

    /**
     * action update statut canditature à revoir
     */
    @POST
    @Path("/qualifierCand")
    @Produces({MediaType.APPLICATION_JSON})
    public synchronized String updateCandidatureState(@PathParam("sid") String sid, @QueryParam("idSessionUV") String idSessionUV, @QueryParam("idCandidature") String idCandidature, @QueryParam("statut") String statut) {
        //recupère l'agent connecté
        if (guichetMetier.estConnexion(sid)) {
            System.out.println("lala");
            //on recupère l'agent
            Agent_M a = guichetMetier.check_SID_Agent_M(sid);
            if (guichetMetier.verifGestionnaire(a)) {
                System.out.println("loooo");
                Candidature m = new Candidature();
               // if (m.getIdCandidature().equals(idCandidature)) {
                    System.out.println("yyyyya");
                    // parcours de la liste candidature_M
                    boolean update = guichetMetier.updateCandidature(m, statut, idCandidature, idSessionUV);
                    if (update) {
                        return "Votre statut pour la session" + idSessionUV + "a été modifié";
                    } else {
                        System.out.println("vivi");
                        return "vous n'existez pas dans cette session";
                    }

                }
            }
       // }
        return "problème de connexion";
    }
   
*/
}
