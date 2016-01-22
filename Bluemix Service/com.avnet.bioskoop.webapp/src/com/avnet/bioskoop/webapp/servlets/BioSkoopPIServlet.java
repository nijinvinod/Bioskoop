package com.avnet.bioskoop.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avnet.bioskoop.webapp.servlethandler.BioSkoopPIServletHandler;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class BioSkoopPIServlet
 */
@WebServlet("/BioSkoopPIServlet")
public class BioSkoopPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BioSkoopPIServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user1Handle = request.getParameter("user1handle");
		String user2Handle = request.getParameter("user2handle");
		System.out.println("User 1 handle :" + user1Handle);

		BioSkoopPIServletHandler handler = new BioSkoopPIServletHandler();
		handler.getUserPersonality(user1Handle, user2Handle);

		System.out.println("Hello PI Servlet");

		JSONObject responseList = handler.getUserPersonality(user1Handle,
				user2Handle);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(responseList.toString());
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
