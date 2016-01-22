package com.avnet.bioskoop.twitter.test;

import java.io.IOException;
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
import twitter4j.auth.AccessToken;

import com.avnet.bioskoop.alchemy.impl.TweetAlchemyAnalyzer;
import com.avnet.bioskoop.alchemy.test.AlchemyTest;
import com.avnet.bioskoop.commons.beans.ProcessedTweetBean;
import com.avnet.bioskoop.commons.beans.UserTweets;
import com.avnet.bioskoop.twitter.constants.TwitterConstants;
import com.avnet.bioskoop.twitter.impl.HashtagAnalyzer;
import com.ibm.json.java.JSONObject;

public class TwitterTest {

	public static void main(String[] args) throws XPathExpressionException, TwitterException, IOException, SAXException, ParserConfigurationException {
	
/*		HashtagAnalyzer h = new HashtagAnalyzer();
		JSONObject arr  = h.getTweetsOfHashtag("InterStellar");
		
		System.out.println("Json :"+arr);
		
		
	
		
		
		
	*/	
		/*Twitter unauthenticatedTwitter = new TwitterFactory().getInstance();
		

		unauthenticatedTwitter.setOAuthConsumer(TwitterConstants.CONSUMER_TOKEN,
				TwitterConstants.CONSUMER_SECRET);
		unauthenticatedTwitter.setOAuthAccessToken(new AccessToken(
				TwitterConstants.ACCESS_TOKEN, TwitterConstants.ACCESS_SECRET));*/
		//First param of Paging() is the page number, second is the number per page (this is capped around 200 I think.
		//Paging paging = new Paging(1, 100);
		
		/*Query hashTagQuery = new Query("#IamRahulKannan");
		hashTagQuery.setCount(100);
		QueryResult tweetResult = unauthenticatedTwitter.search(hashTagQuery);
		List<Status> tweetStatus = tweetResult.getTweets();
		System.out.println("Lang :"+tweetStatus.get(0).getLang());
		
		for(int i = 0;i<tweetStatus.size();i++)
		{
			System.out.println("Tweet :"+tweetStatus.get(i).getText());
			ProcessedTweetBean t  = TweetAlchemyAnalyzer.getTweetsSentiment(tweetStatus.get(i).getText());
			System.out.println("Bean :"+t);
		}*/
		
		HashtagAnalyzer h = new HashtagAnalyzer();
		UserTweets userTweets = HashtagAnalyzer.getTweetsOfAUser("abrahamrkj", "kannankannan123");
		
		for(int i = 0;i<userTweets.getUser1Tweets().size();i++)
		{
			System.out.println("Tweet of AB:"+i+" - "+userTweets.getUser1Tweets().get(i));
		}
		
		for(int i = 0;i<userTweets.getUser2Tweets().size();i++)
		{
			System.out.println("Tweet of Kannan :"+i+" - "+userTweets.getUser2Tweets().get(i));
		}
	//	h.getTweetsOfHashtag("#Interstellar");
		
		//List<Status> statuses = unauthenticatedTwitter.getUserTimeline("kannankannan123",paging);	
		
		
		/*List<String> statuses = HashtagAnalyzer.getTweetsOfAUser("kannankannan123");
	
		System.out.println("Status size :"+statuses.size());
		System.out.println("Statuses :"+statuses.get(2));*/
		
	}
}
