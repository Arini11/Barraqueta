package objectes;

import java.time.LocalDateTime;

public class Tweet {
	private String id;
	private String text;
	private int likes;
	private LocalDateTime data;
	
	public Tweet(String id, String text) {
		this.id = id;
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTweet() {
		return text;
	}
	public void setTweet(String text) {
		this.text = text;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
