package com.avnet.bioskoop.commons.beans;

public class NegativeTweets {
	private int count;

	private Tweets[] tweets;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Tweets[] getTweets() {
		return tweets;
	}

	public void setTweets(Tweets[] tweets) {
		this.tweets = tweets;
	}

	@Override
	public String toString() {
		return "ClassPojo [count = " + count + ", tweets = " + tweets + "]";
	}
}
