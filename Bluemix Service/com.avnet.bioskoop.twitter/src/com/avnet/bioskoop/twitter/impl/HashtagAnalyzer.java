package com.avnet.bioskoop.twitter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

import com.avnet.bioskoop.alchemy.impl.TweetAlchemyAnalyzer;
import com.avnet.bioskoop.commons.beans.FinalBean;
import com.avnet.bioskoop.commons.beans.NegativeTweets;
import com.avnet.bioskoop.commons.beans.NeutralTweets;
import com.avnet.bioskoop.commons.beans.PositiveTweets;
import com.avnet.bioskoop.commons.beans.ProcessedTweetBean;
import com.avnet.bioskoop.commons.beans.Tweets;
import com.avnet.bioskoop.commons.beans.UserDetails;
import com.avnet.bioskoop.commons.beans.UserTweets;
import com.avnet.bioskoop.commons.util.BeanToJsonConverter;
import com.avnet.bioskoop.twitter.constants.TwitterConstants;
import com.avnet.bioskoop.twitter.util.ImageURLTrimmer;
import com.ibm.json.java.JSONObject;

public class HashtagAnalyzer {

	public JSONObject getTweetsOfHashtag(String hashTag, String alchemyAPIKey)
			throws TwitterException, XPathExpressionException, IOException,
			SAXException, ParserConfigurationException {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TwitterConstants.CONSUMER_TOKEN,
				TwitterConstants.CONSUMER_SECRET);
		twitter.setOAuthAccessToken(new AccessToken(
				TwitterConstants.ACCESS_TOKEN, TwitterConstants.ACCESS_SECRET));

		Query hashTagQuery = new Query(hashTag);
		hashTagQuery.setCount(20);
		QueryResult tweetResult = twitter.search(hashTagQuery);
		List<Status> tweetStatus = tweetResult.getTweets();
		
		NegativeTweets negativeTweets = new NegativeTweets();
		PositiveTweets positiveTweets = new PositiveTweets();
		NeutralTweets neutralTweets = new NeutralTweets();
		FinalBean finalBean = new FinalBean();

		System.out.println("Tweet Size :" + tweetStatus.size());

		Tweets[] positiveTweetsArray = new Tweets[tweetStatus.size()];
		Tweets[] negativeTweetsArray = new Tweets[tweetStatus.size()];
		Tweets[] neutralTweetsArray = new Tweets[tweetStatus.size()];

		int positivecount = 0;
		int negativecount = 0;
		int neutralcount = 0;

		Tweets[] tweet = new Tweets[tweetStatus.size()];
		for (int i = 0; i < tweetStatus.size(); i++) {

			if (tweetStatus.get(i).getLang().equals("en")) {
				// System.out.println("Lang :"+tweetStatus.get(i).getLang());
				System.out.println("Tweet No :" + i);
				System.out.println("Tweet :" + tweetStatus.get(i).getText());
				System.out.println("Lang :" + tweetStatus.get(i).getLang());
				tweet[i] = new Tweets();
				tweet[i].setMessage(tweetStatus.get(i).getText());
				User user = tweetStatus.get(i).getUser();
				tweet[i].setUser(user.getName());
				tweet[i].setUserHandlerName(user.getScreenName());
				String imageURL = ImageURLTrimmer.removeNormalFromURL(user
						.getProfileImageURLHttps());
				tweet[i].setUserImageURL(imageURL);
				ProcessedTweetBean processedBean = TweetAlchemyAnalyzer
						.getTweetsSentiment(tweet[i].getMessage(),
								alchemyAPIKey);
				tweet[i].setProcessedBean(processedBean);

				System.out.println("Image URL :" + imageURL);
				UserDetails userDetails = TweetAlchemyAnalyzer.getImageDetails(
						imageURL, alchemyAPIKey);
				System.out.println("User details in loop :" + userDetails);
				tweet[i].setUserDetails(userDetails);
				if (processedBean.getDocSentiment() != null
						&& processedBean.getLanguage().equals("english")) {
					if (processedBean.getDocSentiment().getType()
							.equals(TwitterConstants.POSITIVE)) {

						tweet[i].setSentiment(processedBean.getDocSentiment()
								.getType());
						positivecount = positivecount + 1;
						positiveTweetsArray[i] = tweet[i];
						positiveTweets.setTweets(positiveTweetsArray);
					} else if (processedBean.getDocSentiment().getType()
							.equals(TwitterConstants.NEGATIVE)) {
						tweet[i].setSentiment(processedBean.getDocSentiment()
								.getType());
						negativecount = negativecount + 1;
						negativeTweetsArray[i] = tweet[i];
						negativeTweets.setTweets(negativeTweetsArray);

					} else if (processedBean.getDocSentiment().getType()
							.equals(TwitterConstants.NEUTRAL)) {
						tweet[i].setSentiment(processedBean.getDocSentiment()
								.getType());
						neutralcount = neutralcount + 1;
						neutralTweetsArray[i] = tweet[i];
						neutralTweets.setTweets(neutralTweetsArray);

					}
				}
			} else {
				System.out.println("Lang :" + tweetStatus.get(i).getLang());
			}

		}

		positiveTweets.setCount(positivecount);
		negativeTweets.setCount(negativecount);
		neutralTweets.setCount(neutralcount);

		finalBean.setTotalCount(tweetStatus.size());
		finalBean.setNegativeTweets(negativeTweets);
		finalBean.setPositiveTweets(positiveTweets);
		finalBean.setNeutralTweets(neutralTweets);
		finalBean.setHashTag(hashTag);

		String json = BeanToJsonConverter.convertFinalBeanToJson(finalBean);

		JSONObject obj = new JSONObject();
		obj = JSONObject.parse(json);

		System.out.println("Object :" + obj);

		/*
		 * System.out.println("Twitter search successful!!:" +
		 * tweetResult.getTweets().size());
		 * 
		 * List<Status> statusList = new ArrayList<Status>(); List<String>
		 * tweetTextList = new ArrayList<String>(); List<String> userTweet = new
		 * ArrayList<String>(); List<String> userProfile = new
		 * ArrayList<String>(); List<String> userProfileLink = new
		 * ArrayList<String>(); // List<String> sentimentList = new
		 * ArrayList<String>();
		 * 
		 * if (tweetResult.getTweets().size() > 0) { statusList =
		 * tweetResult.getTweets(); for (int i = 0; i < statusList.size(); i++)
		 * {
		 * 
		 * Status status = statusList.get(i);
		 * tweetTextList.add(status.getText()); userTweet.add(status.getText());
		 * userProfile.add(status.getUser().getName());
		 * userProfileLink.add(status.getUser().getURL()); } }
		 * 
		 * 
		 * TweetSentimentAnalyzer ta = new TweetSentimentAnalyzer(); try {
		 * sentimentList = ta.getTweetsSentiment(tweetTextList);
		 * 
		 * } catch (XPathExpressionException | SAXException |
		 * ParserConfigurationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * JSONArray resArray = new JSONArray();
		 * 
		 * for (int i = 0; i < statusList.size(); i++) { JSONObject item = new
		 * JSONObject();
		 * 
		 * item.put("msg", userTweet.get(i)); item.put("user",
		 * userProfile.get(i)); item.put("userLink", userProfileLink.get(i)); //
		 * item.put("sentiment", sentimentList.get(i)); resArray.add(item); }
		 */
		return obj;

	}

	public static UserTweets getTweetsOfAUser(String user1Handle,
			String user2Handle) throws TwitterException {

		UserTweets userTweets = new UserTweets();
		Twitter twitter = new TwitterFactory().getInstance();

		twitter.setOAuthConsumer(TwitterConstants.CONSUMER_TOKEN,
				TwitterConstants.CONSUMER_SECRET);
		twitter.setOAuthAccessToken(new AccessToken(
				TwitterConstants.ACCESS_TOKEN, TwitterConstants.ACCESS_SECRET));
		// First param of Paging() is the page number, second is the number per
		// page (this is capped around 200 I think.
		Paging paging = new Paging(1, 100);
		if (user1Handle != null) {
			List<Status> user1Statuses = twitter.getUserTimeline(user1Handle,
					paging);
			if (user1Statuses.size() != 0) {
				List<String> user1Tweets = new ArrayList<String>();
				for (int i = 0; i < user1Statuses.size(); i++) {
					user1Tweets.add(user1Statuses.get(i).getText());
				}
				userTweets.setUser1Tweets(user1Tweets);
			}

		}

		if (user2Handle != null) {
			List<Status> user2Statuses = twitter.getUserTimeline(user2Handle,
					paging);

			if (user2Statuses.size() != 0) {
				List<String> user2Tweets = new ArrayList<String>();
				for (int i = 0; i < user2Statuses.size(); i++) {
					user2Tweets.add(user2Statuses.get(i).getText());
					userTweets.setUser2Tweets(user2Tweets);
				}
			}
		}

		return userTweets;

	}

}
