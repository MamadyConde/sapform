package fr.caos.Pompiers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.caos.data.GuichetMetier;
import fr.caos.metier.Agent_M;



@Path("/authentification")
public class AuthentificationManager {
	@GET
	@Path("login")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	public String authoriz(@QueryParam("login") String login, @QueryParam("password") String password,@Context HttpServletRequest request) {

		GuichetMetier managerMetier = GuichetMetier.getGuichetMetier();
		for (Agent_M a : managerMetier.getGlobale_list_agents()) {
			if (a.getLogin().equals(login) && a.getPassword().equals(password)) {
				// Retourne la session en cours associée à la requete ou en crée
				// une
				HttpSession sessionInformatique = request.getSession();

				String sid = sessionInformatique.getId();

				return sid;
			}

		}
		return null;

	}

	@POST
	@Path("/logout")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	public String logout(@Context HttpServletRequest request) {
		/* Récupération et destruction de la session en cours */
		HttpSession sessionInformatique = request.getSession();
		sessionInformatique.invalidate();

		return "session detruite";

	}
}
