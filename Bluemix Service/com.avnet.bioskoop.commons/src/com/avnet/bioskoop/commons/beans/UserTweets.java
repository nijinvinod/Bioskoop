package com.avnet.bioskoop.commons.beans;

import java.util.List;

public class UserTweets {
	
	private List<String> user1Tweets;
	
	private List<String> user2Tweets;

	public List<String> getUser1Tweets() {
		return user1Tweets;
	}

	public void setUser1Tweets(List<String> user1Tweets) {
		this.user1Tweets = user1Tweets;
	}

	public List<String> getUser2Tweets() {
		return user2Tweets;
	}

	public void setUser2Tweets(List<String> user2Tweets) {
		this.user2Tweets = user2Tweets;
	}

	@Override
	public String toString() {
		return "UserTweets [user1Tweets=" + user1Tweets + ", user2Tweets="
				+ user2Tweets + "]";
	}
	
	
	
}
