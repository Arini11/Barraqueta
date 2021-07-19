package presentacio.accions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import objectes.UsuariTW;
import presentacio.Action;

public class FeedTwitter implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String usuari = null;
		String dades = "";
		UsuariTW usr = new UsuariTW();
		try {
			usuari = request.getParameter("usuari");
			String url = "https://nitter.domain.glass/"+usuari+"/rss";
			System.out.println(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(res.toString())));
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		request.setAttribute("usr", usr);
		String nextPage = "jsp/feedTwitter.jsp";
		return nextPage;
	}
}
