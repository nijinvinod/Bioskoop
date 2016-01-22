package com.avnet.bioskoop.webapp.servlethandler;

import java.util.List;

import com.avnet.bioskoop.commons.beans.User1PI;
import com.avnet.bioskoop.commons.beans.User2PI;
import com.avnet.bioskoop.commons.beans.UserTweets;
import com.avnet.bioskoop.commons.util.JsonToBeanConverter;
import com.avnet.bioskoop.personalityinsights.impl.PersonalityInsightsServiceImpl;
import com.avnet.bioskoop.twitter.impl.HashtagAnalyzer;
import com.ibm.json.java.JSONObject;

public class BioSkoopPIServletHandler {
	public JSONObject getUserPersonality(String user1Handle, String user2Handle) {

		JSONObject obj = new JSONObject();
		try {

			UserTweets userTweets = HashtagAnalyzer.getTweetsOfAUser(
					user1Handle, user2Handle);

			String user1FullTweets = "";
			String user2FullTweets = "";
			if (userTweets != null) {
				if (userTweets.getUser1Tweets() != null) {
					if (userTweets.getUser1Tweets().size() > 0) {
						System.out.println("inside user 1 file");
						List<String> user1Tweets = userTweets.getUser1Tweets();

						for (int i = 0; i < user1Tweets.size(); i++) {
							user1FullTweets = user1FullTweets
									+ user1Tweets.get(i) + ". ";
						}

						/*
						 * FileWriter user1File = new
						 * FileWriter("user1tweets.txt"); for (String str :
						 * user1Tweets) { user1File.write(str); }
						 * user1File.close();
						 */
					}
				}
				if (userTweets.getUser2Tweets() != null) {
					if (userTweets.getUser2Tweets().size() > 0) {
						System.out.println("inside user 2 file");
						List<String> user2Tweets = userTweets.getUser2Tweets();

						for (int i = 0; i < user2Tweets.size(); i++) {
							user2FullTweets = user2FullTweets
									+ user2Tweets.get(i) + ". ";
						}

						/*
						 * FileWriter user2File = new
						 * FileWriter("user2tweets.txt"); for (String str :
						 * user2Tweets) { user2File.write(str); }
						 * user2File.close();
						 */
					}
				}
			}

			PersonalityInsightsServiceImpl piservice = new PersonalityInsightsServiceImpl();

			String user1Json = piservice.getPersonality(user1FullTweets);
			String user2Json = piservice.getPersonality(user2FullTweets);

			User1PI user1PI = JsonToBeanConverter.convertUser1PIJson(user1Json);
			User2PI user2PI = JsonToBeanConverter.convertUser2PIJson(user2Json);

			String fullJson = "";
			if (user1PI.getWord_count() == null
					&& user2PI.getWord_count() != null) {
				user1Json = "{}";
				user1Json = "{ \"user1PI\":" + user1Json + ",";
				user2Json = "\"user2PI\": " + user2Json + "}";
				fullJson = user1Json + user2Json;
			}

			if (user1PI.getWord_count() != null
					&& user2PI.getWord_count() == null) {

				user1Json = "{ \"user1PI\":" + user1Json + ",";
				user2Json = "{}";
				user2Json = "\"user2PI\": " + user2Json + "}";
				fullJson = user1Json + user2Json;
			}

			if (user1PI.getWord_count() == null
					&& user2PI.getWord_count() == null) {
				user1Json = "{}";
				user1Json = "{ \"user1PI\":" + user1Json + ",";
				user2Json = "{}";
				user2Json = "\"user2PI\": " + user2Json + "}";
				fullJson = user1Json + user2Json;
			}

			if (user1PI.getWord_count() != null
					&& user2PI.getWord_count() != null) {

				user1Json = "{ \"user1PI\":" + user1Json + ",";

				user2Json = "\"user2PI\": " + user2Json + "}";
				fullJson = user1Json + user2Json;
			}

			/*
			 * User1PI user1PI =
			 * JsonToBeanConverter.convertUser1PIJson(user1Json); User2PI
			 * user2PI = JsonToBeanConverter.convertUser2PIJson(user2Json);
			 * System.out.println("User 1 bean :"+user1PI);
			 * System.out.println("User 2 bean :"+user2PI);
			 * PersonalityInsightsBean piBean = new PersonalityInsightsBean();
			 * piBean.setUser1PI(user1PI); piBean.setUser2PI(user2PI); String
			 * json = BeanToJsonConverter
			 * .convertPersonalityInsightsBeanToJson(piBean);
			 */

			obj = JSONObject.parse(fullJson);

			System.out.println("PI Json :" + fullJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
