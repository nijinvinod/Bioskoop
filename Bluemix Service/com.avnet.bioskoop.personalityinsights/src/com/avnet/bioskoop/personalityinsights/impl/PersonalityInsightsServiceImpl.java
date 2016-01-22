package com.avnet.bioskoop.personalityinsights.impl;

import java.io.IOException;
import java.net.URI;

import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class PersonalityInsightsServiceImpl {

	public String getPersonality(String tweets) throws URISyntaxException,
			ClientProtocolException, IOException {
		String baseURL = "https://gateway.watsonplatform.net/personality-insights/api";
		String username = "ead5f779-dd97-4aaf-a8b3-5ef2358e3532";
		String password = "DDVXPNky8vbz";

		URI profileURI = new URI(baseURL + "/v2/profile").normalize();

		Request profileRequest = Request.Post(profileURI)
				.addHeader("Accept", "application/json")
				.bodyString(tweets, ContentType.TEXT_PLAIN);

		Executor executor = Executor.newInstance().auth(username, password);
		Response response = executor.execute(profileRequest);
		HttpResponse httpResponse = response.returnResponse();
		String json = EntityUtils.toString(httpResponse.getEntity());
		System.out.println("JSON :" + json);
		return json;
	}
}
