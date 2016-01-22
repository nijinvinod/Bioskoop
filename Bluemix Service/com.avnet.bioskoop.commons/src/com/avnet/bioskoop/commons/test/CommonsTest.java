package com.avnet.bioskoop.commons.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.avnet.bioskoop.commons.util.JsonToBeanConverter;

public class CommonsTest {

	public static void main(String[] args) throws IOException {
		
		String stringBufferList = null;
		String staticURL = "http://access.alchemyapi.com/calls/text/TextGetTextSentiment?apikey=5e2af28d0661a2ef823d13d515f5c39f57d407a0&outputMode=json&text=";
		String requestURL = "";

		requestURL = staticURL + URLEncoder.encode("Charles is a very very bad boy", "UTF-8");
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
		stringBufferList = responseBuffer.toString();

		responseBuffer.setLength(0);

		System.out.println("Response Buffer:"+stringBufferList);

		
		
		
		
		
		
		
	
		
	
	JsonToBeanConverter conn = new JsonToBeanConverter();
		conn.convertSentimentTweetJson(stringBufferList);
	}
}
