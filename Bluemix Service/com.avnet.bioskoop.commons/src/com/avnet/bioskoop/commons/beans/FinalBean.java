package com.avnet.bioskoop.commons.beans;

public class FinalBean {
	private String hashTag;

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	private PositiveTweets positiveTweets;

	private int totalCount;

	private NegativeTweets negativeTweets;

	private NeutralTweets neutralTweets;

	public NeutralTweets getNeutralTweets() {
		return neutralTweets;
	}

	public void setNeutralTweets(NeutralTweets neutralTweets) {
		this.neutralTweets = neutralTweets;
	}

	public PositiveTweets getPositiveTweets() {
		return positiveTweets;
	}

	public void setPositiveTweets(PositiveTweets positiveTweets) {
		this.positiveTweets = positiveTweets;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public NegativeTweets getNegativeTweets() {
		return negativeTweets;
	}

	public void setNegativeTweets(NegativeTweets negativeTweets) {
		this.negativeTweets = negativeTweets;
	}

	@Override
	public String toString() {
		return "FinalBean [hashTag=" + hashTag + ", positiveTweets="
				+ positiveTweets + ", totalCount=" + totalCount
				+ ", negativeTweets=" + negativeTweets + ", neutralTweets="
				+ neutralTweets + "]";
	}

}
