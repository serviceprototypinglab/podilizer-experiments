package com.company;

import java.io.IOException;
import java.lang.NumberFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

class Servlet extends AbstractHandler
{
	public Servlet()
	{
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		//// begin application code
		Box box0 = new Box();
		Box box1 = new Box(1, 1, 1);
		Box box2 = new Box(2, 3, 4);
		BoxContainer boxContainer = new BoxContainer();
		boxContainer.addBox(box0);
		boxContainer.addBox(box1);
		boxContainer.addBox(box2);
		System.out.println("The total boxes volume is " + boxContainer.totalVolume());
		//// end application code

		response.getWriter().println("<h1>Hello World</h1>");
		baseRequest.setHandled(true);
	}

	public static void main(String[] args) throws Exception
	{
		int port = 8080;
		try
		{
			port = Integer.parseInt(System.getenv().get("PORT"));
		}
		catch(NumberFormatException e)
		{
			// use default
		}
		Server server = new Server(port);
		server.setHandler(new Servlet());
		server.start();
		server.join();
	}
}
