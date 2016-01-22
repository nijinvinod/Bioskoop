package com.avnet.bioskoop.webapp.test;

import java.util.List;

import com.avnet.bioskoop.webapp.servlethandler.BioSkoopMainServletHandler;
import com.ibm.json.java.JSONObject;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class TestClass {
	public static final String CONSUMER_TOKEN = "dwU6tfiJQoCSYVbOwIyEcPlDh",
			CONSUMER_SECRET = "bKApaPKKYjNCJ6gEjnw7LwJvMPo5Ne6ZH44WsfvMhQwWPRMc6B",
					ACCESS_TOKEN = "2282514752-PJhAY0iewgBTbtXX6ZGsMcllBPVVPnR6zY6nf4n",
					ACCESS_SECRET = "Jwa7vpB9Hkyi1KBtTXN97WvFQbzIITKyqEGFrhzuJrSJk";

	public static void main(String[] args) throws TwitterException {
	
		
		/*BioSkoopMainServletHandler s = new BioSkoopMainServletHandler();
		JSONObject o  = s.getProcessedTweets("IamRahulKannan");*/
	/*	Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_TOKEN, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN,
				ACCESS_SECRET));
		Query query1 = new Query("#PowerOfStyle");
		query1.setCount(5);
		
		
		// Query query2 = new Query("#voteforhillaryclinton");

		QueryResult result1 = twitter.search(query1);
		// QueryResult result2 = twitter.search(query2);

		
		System.out.println("Twitter search successful!!:"
				+ result1.getTweets().size());
		
		List<Status> statuses =  result1.getTweets();
		User user = statuses.get(0).getUser();
		
		System.out.println("User :"+user.getProfileImageURLHttps());
		System.out.println("Text :"+statuses.get(0).getText());
		
		String imageURL = result1.getTweets().get(0).getUser().getProfileImageURLHttps();
		System.out.println("Image URL:"+imageURL);
		imageURL = imageURL.replaceFirst("_normal","");
		System.out.println("Image URL After :"+imageURL);
		System.out.println("Screen name :"+user.getScreenName());
		System.out.println("Loc:"+statuses.get(0).getUser().getLocation());
		Place place = statuses.get(0).getPlace();
		
		System.out.println("Country:"+place.getCountry());
		System.out.println("GEO Location :"+statuses.get(0).getGeoLocation());
		
		
		*/
		
	}

}
