package com.avnet.bioskoop.alchemy.beans;

public class TwitterBean {

	private String positiveTweets;
	private String negativeTweets;
	private String totalTweets;

	public String getPositiveTweets() {
		return positiveTweets;
	}

	public void setPositiveTweets(String positiveTweets) {
		this.positiveTweets = positiveTweets;
	}

	public String getNegativeTweets() {
		return negativeTweets;
	}

	public void setNegativeTweets(String negativeTweets) {
		this.negativeTweets = negativeTweets;
	}

	public String getTotalTweets() {
		return totalTweets;
	}

	public void setTotalTweets(String totalTweets) {
		this.totalTweets = totalTweets;
	}

	@Override
	public String toString() {
		return "TwitterBean [positiveTweets=" + positiveTweets
				+ ", negativeTweets=" + negativeTweets + ", totalTweets="
				+ totalTweets + "]";
	}

}
