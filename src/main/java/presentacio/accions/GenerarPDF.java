package presentacio.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.LogicaFacade;
import presentacio.Action;


public class GenerarPDF implements Action {
	
	public GenerarPDF() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// obtenir dades formulari
		String nom = request.getParameter("nom");
		String cognoms = request.getParameter("cognoms");
		String lloc = request.getParameter("lloc");
		String data = request.getParameter("data");
		
		LogicaFacade dades = new LogicaFacade();
		//dades.generarPDF(nom,cognoms,lloc,data);
		
		return "comanda.pdf";
	}
}
