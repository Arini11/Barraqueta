package presentacio.accions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;
import objectes.UsuariTW;
import presentacio.Action;

public class FeedTwitter implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String usuari = null;
		UsuariTW usr = new UsuariTW();
		try {
			usuari = request.getParameter("usuari");
			URL url = new URL("https://api.twitter.com/2/users/by/username/"+usuari+"?user.fields=created_at,description,entities,location,pinned_tweet_id,profile_image_url,public_metrics,url");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAACjrRgEAAAAA3aMvMcfH3i3kI%2FfLiuHV5Im3sn4%3D6gqnVQyplMBFZ1F1yBzLRDvsMUesZHnsasalOdh23GuzlsvESk");
			http.setRequestMethod("GET");
			System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(http.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
			
			JSONObject jsonObject = (JSONObject) JSONValue.parse(res.toString());
			JSONObject dades = (JSONObject) jsonObject.get("data");
			String id = (String) dades.get("id");
	        String nom = (String) dades.get("name");
	        String descripcio = (String) dades.get("description");
	        String username = (String) dades.get("username");
	        String imatge = (String) dades.get("profile_image_url");
	        String ubicacio = (String) dades.get("location");
	        String data = (String) dades.get("created_at");
	        if(dades.get("public_metrics") instanceof HashMap) {
	        	Map<String,Object> public_metrics = (HashMap<String,Object>) dades.get("public_metrics");
		        Long tweet_count = new Long((long) public_metrics.get("tweet_count"));
		        Long following_count = new Long((long) public_metrics.get("following_count"));
		        Long followers_count = new Long((long) public_metrics.get("followers_count"));
		        usr.setNTweets(tweet_count);
		        usr.setNSeguint(following_count);
		        usr.setNSeguidors(followers_count);
	        }else {
	        	System.out.print("Error FeedTwitter.java dades.get('public_metrics') no és un HashMap");
	        }
	        
	        usr.setId(id);
	        usr.setNom(nom);
	        usr.setDescripcio(descripcio);
	        usr.setUsername(username);
	        usr.setImatge(imatge.replace("_normal", ""));
	        usr.setUbicacio(ubicacio);
	        usr.setData(data);
	        
			http.disconnect();
			
			// OBTENIR TWEETS
			URL url2 = new URL("http://api.twitter.com/2/users/1145367785008185344/tweets?exclude=replies&max_results=12");
			HttpURLConnection http2 = (HttpURLConnection)url2.openConnection();
			http2.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAACjrRgEAAAAA3aMvMcfH3i3kI%2FfLiuHV5Im3sn4%3D6gqnVQyplMBFZ1F1yBzLRDvsMUesZHnsasalOdh23GuzlsvESk");
			http2.setRequestMethod("GET");
			System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
			String redirect2 = http2.getHeaderField("Location");
			if (redirect2 != null){
				http2 = (HttpURLConnection) new URL(redirect2).openConnection();
				http2.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAACjrRgEAAAAA3aMvMcfH3i3kI%2FfLiuHV5Im3sn4%3D6gqnVQyplMBFZ1F1yBzLRDvsMUesZHnsasalOdh23GuzlsvESk");
				http2.setRequestProperty("Accept", "application/json");
				http2.setRequestMethod("GET");
				System.out.println("redirecció");
				//for(int i=0;http2.getHeaderField(i) != null;i++)
					//System.out.println(http2.getHeaderField(i));
			}
			System.out.println(http2.getResponseCode() + " " + http2.getResponseMessage());
			
			BufferedReader in2 = new BufferedReader(
					new InputStreamReader(http2.getInputStream(),"UTF-8"));
			String inputLine2;
			StringBuffer res2 = new StringBuffer();
			while ((inputLine2 = in2.readLine()) != null) {
				res2.append(inputLine2);
			}
			in2.close();
			
			// remplaço els caràcters amb codi decimal 65039 perquè és un caràcter que surt, no sé exactament
			// per què, després dels emojis. És un símbol estrany, que es carrega com un interrogant
			// He tingut prou feines per solucionar-ho, però ja està
			// https://stackoverflow.com/questions/68468491/java-unicode-strange-behaviour 
			JSONObject jsonObject2 = (JSONObject) JSONValue.parse(res2.toString().replace((char)65039, ' '));
			JSONArray dades2 = (JSONArray) jsonObject2.get("data");
	        for (int i = 0; i < dades2.size(); i++) {
	        	JSONObject jsonObject3 = (JSONObject)dades2.get(i);
	        	String id_ = (String) jsonObject3.get("id");
	        	String text_ = (String) jsonObject3.get("text");
	        	usr.afegirTweet(id_,text_);
	        }
	        http2.disconnect();
		 //System.out.println(EmojiManager.getForAlias(":cherries:"));
		 //System.out.println(EmojiManager.getForAlias(":diamonds:"));
		 //System.out.println(EmojiManager.getForAlias(":exclamation:"));
			
		} catch(Exception e) {e.printStackTrace();}
		request.setAttribute("usr", usr);
		String nextPage = "jsp/feedTwitter.jsp";
		return nextPage;
	}
}
