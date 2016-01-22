package com.avnet.bioskoop.webapp.servlethandler;

import com.avnet.bioskoop.twitter.impl.HashtagAnalyzer;
import com.ibm.json.java.JSONObject;

public class BioSkoopMainServletHandler {

	public JSONObject getProcessedTweets(String hashTag,String apiKey) {
	
		JSONObject obj = null;
		try {
			HashtagAnalyzer hashTagAnalyzer = new HashtagAnalyzer();
			obj = hashTagAnalyzer.getTweetsOfHashtag(hashTag, apiKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
