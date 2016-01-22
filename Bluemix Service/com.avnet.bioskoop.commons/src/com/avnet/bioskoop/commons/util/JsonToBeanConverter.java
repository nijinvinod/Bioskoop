package com.avnet.bioskoop.commons.util;

import com.avnet.bioskoop.commons.beans.PersonalityInsightsBean;
import com.avnet.bioskoop.commons.beans.ProcessedTweetBean;
import com.avnet.bioskoop.commons.beans.User1PI;
import com.avnet.bioskoop.commons.beans.User2PI;
import com.avnet.bioskoop.commons.beans.UserDetails;
import com.google.gson.Gson;

public class JsonToBeanConverter {

	public static ProcessedTweetBean convertSentimentTweetJson(String json) {

		Gson gson = new Gson();
		ProcessedTweetBean processedBean = gson.fromJson(json,
				ProcessedTweetBean.class);
		System.out.println("Bean:" + processedBean);
		return processedBean;
	}

	public static UserDetails convertImageDetailsJson(String json) {

		Gson gson = new Gson();
		UserDetails userDetailsBean = gson.fromJson(json, UserDetails.class);
		System.out.println("Bean:" + userDetailsBean);
		return userDetailsBean;
	}

	public static User1PI convertUser1PIJson(String json) {

		Gson gson = new Gson();
		User1PI user1PI = gson.fromJson(json, User1PI.class);
		System.out.println("Bean:" + user1PI);
		return user1PI;
	}

	public static User2PI convertUser2PIJson(String json) {

		Gson gson = new Gson();
		User2PI user2PI = gson.fromJson(json, User2PI.class);
		System.out.println("Bean:" + user2PI);
		return user2PI;
	}

	public static PersonalityInsightsBean convertPIJson(String json) {

		Gson gson = new Gson();
		PersonalityInsightsBean personalityInsightsBean = gson.fromJson(json,
				PersonalityInsightsBean.class);
		System.out.println("Bean:" + personalityInsightsBean);
		return personalityInsightsBean;
	}
}
