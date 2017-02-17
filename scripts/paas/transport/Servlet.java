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
		Transport t = new Transport();
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
