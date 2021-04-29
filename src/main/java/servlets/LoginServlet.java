package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setzen des Content Type
		response.setContentType("text/html");
		// Den PrintWriter deklarieren.
		PrintWriter out = response.getWriter();

		// Der Parameter, welcher im Feld Passwort eingegebn wurde wird als String
		// gespeichert.
		String passwort = request.getParameter("passwort");

		// Überprüft ob das richtige Passwort eingegeben wurde (klapp42stuhl).
		if (passwort.equals("1234")) {
			// Wurde das richtige Passwort eingegeben, wird man zum Screen weitergeleitet,
			// wo die Bestellungen angeziegt werden.
			RequestDispatcher dispatcher = request.getRequestDispatcher("BestellungServlet");
			dispatcher.forward(request, response);
		} else {
			/*
			 * Wurde das Falsche Passwort eingegeben, wird der Text "Falsches Passwort!" zur
			 * login.jsp hinzugefügt und man kann es nocheinmal versuchen.
			 */
			out.println("Falsches Passwort!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}
	}
}
