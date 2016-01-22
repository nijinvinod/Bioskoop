package com.avnet.bioskoop.alchemy.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.avnet.bioskoop.commons.beans.ProcessedTweetBean;
import com.avnet.bioskoop.commons.beans.UserDetails;
import com.avnet.bioskoop.commons.util.JsonToBeanConverter;

public class TweetAlchemyAnalyzer {

	public static ProcessedTweetBean getTweetsSentiment(String tweets,String alchemyApiKey)
			throws IOException, SAXException, ParserConfigurationException,
			XPathExpressionException {

		String jsonString = null;
		// avnet account api
		// String staticURL =
		// "http://access.alchemyapi.com/calls/text/TextGetTextSentiment?apikey="+AlchemyConstants.ALCHEMY_API_CODE_1+"&outputMode=json&text=";
	
		// gmail account api
		String staticURL = "http://access.alchemyapi.com/calls/text/TextGetTextSentiment?apikey="
				+ alchemyApiKey
				+ "&outputMode=json&text=";

		String requestURL = "";

		requestURL = staticURL + URLEncoder.encode(tweets, "UTF-8");
		URL obj = new URL(requestURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer responseBuffer = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responseBuffer.append(inputLine);
		}
		in.close();
		jsonString = responseBuffer.toString();

		ProcessedTweetBean processedTweetBean = JsonToBeanConverter
				.convertSentimentTweetJson(jsonString);

		responseBuffer.setLength(0);

		System.out.println("ProcessedBean:" + processedTweetBean);

		return processedTweetBean;
	}

	public static UserDetails getImageDetails(String imageURL,String alchemyApiKey)
			throws IOException {

		String imageJSON = null;
		// String staticURL =
		// "http://access.alchemyapi.com/calls/url/URLGetRankedImageFaceTags?apikey="+AlchemyConstants.ALCHEMY_API_CODE_1+"&outputMode=json&url=";

		String staticURL = "http://access.alchemyapi.com/calls/url/URLGetRankedImageFaceTags?apikey="
				+ alchemyApiKey + "&outputMode=json&url=";
		String requestURL = "";

		requestURL = staticURL + URLEncoder.encode(imageURL, "UTF-8");
		URL obj = new URL(requestURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer responseBuffer = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responseBuffer.append(inputLine);
		}
		in.close();
		imageJSON = responseBuffer.toString();

		responseBuffer.setLength(0);

		UserDetails userDetails = JsonToBeanConverter
				.convertImageDetailsJson(imageJSON);
		System.out.println("User Details Bean:" + userDetails);
		return userDetails;

	}
}
