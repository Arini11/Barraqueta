package presentacio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/frontController")
public class ServletFrontController extends HttpServlet {
	static final long serialVersionUID = 1;

	public ServletFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		Action action=null;
		String nextPage=null;
		String nameAction = request.getParameter("action");
		LogManager.getReference().log(request.getRemoteAddr(), nameAction);
		
		try {
			action = FactoryImpl.getReference().getAction(nameAction);
			nextPage = action.execute(request, response);
			if(nextPage.endsWith(".jsp")) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/"+nextPage));
				rd.forward(request, response);
			} else if(nextPage.endsWith(".pdf")) {
				String ruta = "C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\"+nextPage;
				File pdfFile = new File(ruta);
				response.setContentType("application/pdf");
			    response.setHeader("content-disposition", "inline; filename=\""+nextPage+"\""); 
				response.setContentLength((int) pdfFile.length());

				FileInputStream fileInputStream = new FileInputStream(pdfFile);
				OutputStream responseOutputStream = response.getOutputStream();
				int bytes;
				while ((bytes = fileInputStream.read()) != -1) {
					responseOutputStream.write(bytes);
				}
				fileInputStream.close();
				responseOutputStream.flush();
				responseOutputStream.close();
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		doGet(req, resp);
	}


}
