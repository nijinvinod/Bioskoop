package com.avnet.bioskoop.alchemy.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.avnet.bioskoop.alchemy.impl.TweetAlchemyAnalyzer;
import com.avnet.bioskoop.commons.beans.ProcessedTweetBean;
import com.avnet.bioskoop.commons.beans.UserDetails;

public class AlchemyTest {

	public static void main(String[] args) throws XPathExpressionException,
			IOException, SAXException, ParserConfigurationException {

	
		/*  TweetAlchemyAnalyzer t = new TweetAlchemyAnalyzer(); 
		  String tweets = "#IamRahulKannan , worst experience watching Water."; 
		  String tweets1 = "Dhoni is the best wicket keeper in the world";
		  List<String> tweetsList = new ArrayList<>(); tweetsList.add(tweets);
		  tweetsList.add(tweets1);
		  
		  ProcessedTweetBean tw = TweetAlchemyAnalyzer.getTweetsSentiment(tweets);
		  
		  System.out.println("TW :"+tw);*/
		 

		/*TweetAlchemyAnalyzer t = new TweetAlchemyAnalyzer();
		String tweets = "https://pbs.twimg.com/profile_images/581103294904315904/XkQEo3-g.jpg";
		String tweets1 = "http://upload.wikimedia.org/wikipedia/commons/b/b2/Young_man_exhibiting_a_serious_expression.jpg";
		String tweets2 = "http://cdn.shopify.com/s/files/1/0270/8605/files/9501B.jpg?167";
		List<String> tweetsList = new ArrayList<>();
		tweetsList.add(tweets);
		tweetsList.add(tweets1);
		tweetsList.add(tweets2);
		UserDetails user = TweetAlchemyAnalyzer.getImageDetails(tweets);
		System.out.println("User :"+user.getImageFaces()[0].getGender());*/
	}

}
