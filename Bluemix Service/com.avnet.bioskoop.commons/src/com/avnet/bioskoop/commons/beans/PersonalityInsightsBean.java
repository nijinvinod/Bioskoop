package com.avnet.bioskoop.commons.beans;

public class PersonalityInsightsBean {
	private User1PI user1PI;

	private User2PI user2PI;

	public User1PI getUser1PI() {
		return user1PI;
	}

	public void setUser1PI(User1PI user1PI) {
		this.user1PI = user1PI;
	}

	public User2PI getUser2PI() {
		return user2PI;
	}

	public void setUser2PI(User2PI user2PI) {
		this.user2PI = user2PI;
	}

	@Override
	public String toString() {
		return "PersonalityInsightsBean [user1PI = " + user1PI + ", user2PI = " + user2PI
				+ "]";
	}
}
