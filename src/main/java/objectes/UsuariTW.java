package objectes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsuariTW {
	private String id;
	private String nom;
	private String descripcio;
	private String imatge;
	private String username;
	private String ubicacio;
	private String data;
	private Long nTweets;
	private Long nSeguint;
	private Long nSeguidors;
	private Long nLikes;
	private List<Tweet> tweets;
	
	public UsuariTW(){
		id="";
		nom="";
		descripcio="";
		imatge="";
		username="";
		ubicacio = "";
		data = "";
		nTweets = new Long(0);
		nSeguint = new Long(0);
		nSeguidors = new Long(0);
		nLikes = new Long(0);
		tweets = new ArrayList<Tweet>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id != null)
			this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if(nom != null)
			this.nom = nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		if(descripcio != null)
			this.descripcio = descripcio;
	}
	public String getImatge() {
		return imatge;
	}
	public void setImatge(String imatge) {
		if(imatge != null)
			this.imatge = imatge;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username != null)
			this.username = username;
	}

	public String getUbicacio() {
		return ubicacio;
	}

	public void setUbicacio(String ubicacio) {
		if(ubicacio != null)
			this.ubicacio = ubicacio;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if(data != null) {
			//locale català
			Locale alocale = new Locale("ca", "ES");
			//format per llegir la primera data
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//format per escriure la segona data
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM 'de' yyyy",alocale);
			//passar String d1 a LoclaDate (només agafa fins al dia, la resta ho ignora)
	        LocalDate date = LocalDate.parse(data.substring(0,10), formatter1);
	        //pasasr data a String amb el segon format
	        String d2 = date.format(formatter2);
	        //el format és estrany (de juny del 2019), així que ignoro els tres primers
	        //caràcters i poso la primera lletra a majúscula
	        String dFinal = d2.substring(3,4).toUpperCase()+d2.substring(4);
			this.data = dFinal;
		}
	}

	public String getNTweets() {
		return nTweets.toString();
	}

	public void setNTweets(Long tweet_count) {
		if(tweet_count != null)
			this.nTweets = tweet_count;
	}

	public String getNSeguint() {
		return nSeguint.toString();
	}

	public void setNSeguint(Long nSeguint) {
		if(nSeguint != null)
			this.nSeguint = nSeguint;
	}

	public String getNSeguidors() {
		return nSeguidors.toString();
	}

	public void setNSeguidors(Long nSeguidors) {
		if(nSeguidors != null)
			this.nSeguidors = nSeguidors;
	}

	public String getNLikes() {
		return nLikes.toString();
	}

	public void setNLikes(Long nLikes) {
		if(nLikes != null)
			this.nLikes = nLikes;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void afegirTweet(String id, String text) {
		tweets.add(new Tweet(id,text));
	}
}
