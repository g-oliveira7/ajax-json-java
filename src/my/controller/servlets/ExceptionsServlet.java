package my.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exceptions")
public class ExceptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String receivedParam = req.getParameter("element");
			System.out.println(receivedParam);
			resp.setStatus(200); // OK
			resp.getWriter().write("OK");
		} catch (Exception e) {
			resp.setStatus(500); //Erro interno;
			resp.getWriter().write("Internal Error - 500");
		}
	}
}
