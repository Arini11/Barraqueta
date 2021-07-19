package presentacio.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.LogicaFacade;
import presentacio.Action;


public class GenerarInforme implements Action {
	
	public GenerarInforme() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LogicaFacade dades = new LogicaFacade();

		//dades.generarInforme();
		
		return "informe.pdf";
	}
}
