package com.avnet.bioskoop.commons.beans;

public class Tweets {

	private String message;
	private String user;
	private String userHandlerName;
	private String userImageURL;
	private String userProfile;
	private ProcessedTweetBean processedBean;
	private UserDetails userDetails;
	private String sentiment;
	private double score;

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserHandlerName() {
		return userHandlerName;
	}

	public void setUserHandlerName(String userHandlerName) {
		this.userHandlerName = userHandlerName;
	}

	public String getUserImageURL() {
		return userImageURL;
	}

	public void setUserImageURL(String userImageURL) {
		this.userImageURL = userImageURL;
	}

	public ProcessedTweetBean getProcessedBean() {
		return processedBean;
	}

	public void setProcessedBean(ProcessedTweetBean processedBean) {
		this.processedBean = processedBean;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "Tweets [message=" + message + ", userName=" + user
				+ ", userHandlerName=" + userHandlerName + ", userImageURL="
				+ userImageURL + ", userProfile=" + userProfile
				+ ", processedBean=" + processedBean + ", userDetails="
				+ userDetails + ", sentiment=" + sentiment + ", score=" + score
				+ "]";
	}

}
