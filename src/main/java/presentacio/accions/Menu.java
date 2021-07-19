package presentacio.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentacio.Action;

public class Menu implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nextPage = "jsp/benvinguda.jsp";
		return nextPage;
	}
}
