package my.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/eventsCalendar")
public class DataCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = "[{ \"title\" : \"All day event\", \"start\" : \"2021-03-30\" }, { \"title\" : \"Google\", \"url\" : \"http://www.google.com\", \"start\" : \"2021-03-30 17:00\"}]"; /* Nesse momento pode-se fazer busca em banco de dados e então gerar 																	eventos que posteriormente ficarão no Calendário */

		resp.setStatus(200);
		resp.getWriter().write(data);
	}
}
