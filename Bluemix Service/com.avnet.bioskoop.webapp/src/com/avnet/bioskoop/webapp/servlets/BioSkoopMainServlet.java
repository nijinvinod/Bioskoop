package com.avnet.bioskoop.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avnet.bioskoop.webapp.servlethandler.BioSkoopMainServletHandler;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class PersonalityLookUp
 */
@WebServlet("/BioSkoop")
public class BioSkoopMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * public static final String CONSUMER_TOKEN = "dwU6tfiJQoCSYVbOwIyEcPlDh",
	 * CONSUMER_SECRET = "bKApaPKKYjNCJ6gEjnw7LwJvMPo5Ne6ZH44WsfvMhQwWPRMc6B",
	 * ACCESS_TOKEN = "2282514752-PJhAY0iewgBTbtXX6ZGsMcllBPVVPnR6zY6nf4n",
	 * ACCESS_SECRET = "Jwa7vpB9Hkyi1KBtTXN97WvFQbzIITKyqEGFrhzuJrSJk";
	 * 
	 * private String baseURL =
	 * "https://gateway.watsonplatform.net/personality-insights/api"; private
	 * String username = "46dfbfc5-ea30-4222-a1d9-fe6907325ea3"; private String
	 * password = "leob1SMr4EUm";
	 */String staticURL = "http://access.alchemyapi.com/calls/text/TextGetTextSentiment?apikey=5e2af28d0661a2ef823d13d515f5c39f57d407a0&outputMode=json&text=";

	/**
	 * Default constructor.
	 */
	public BioSkoopMainServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			/*
			 * JSONObject hashtagJSON = new JSONObject();
			 * System.out.println("Data :"+request.getParameter("data"));
			 * hashtagJSON = (JSONObject)
			 * JSON.parse(request.getParameter("data"));
			 * 
			 * String hashtag = "#" + (String) hashtagJSON.get("hashtag");
			 */

			String hashtag = "#" + request.getParameter("hashtag");
			String apiKey = request.getParameter("alchemyApi");
			System.out.println("Api Key:"+apiKey);
			// String hashtag = "#IamRahulKannan";
			BioSkoopMainServletHandler handler = new BioSkoopMainServletHandler();
			System.out.println("Hello Servlet");
			// JSONArray resArray = handler.getProcessedTweets(hashtag);
			JSONObject responseList = handler.getProcessedTweets(hashtag,
					apiKey);
			// JSONArray jsonArray = new JSONArray();
			// jsonArray.add(responseList);
			// System.out.println(responseList);
			// responseList.put("result", jsonArray);

			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(responseList.toString());

			// response.getWriter().write("Success");

		} catch (IOException e) {
			System.out.println("Twitter search failure!!");
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
