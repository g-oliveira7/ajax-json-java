package my.controller.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/date-calc")
public class CalculatingDateTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* 1 dia é igual a 8h */
		int umDia = 8;
		int quantidadeDia;
		Date calcDate = null;

		String date = req.getParameter("date");

		double hours = Double.parseDouble(req.getParameter("hours"));

		quantidadeDia = (int) hours / umDia;
		try {
			Date dateInfo = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateInfo);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			if (quantidadeDia == 0) {
				calcDate = dateInfo;
			} else {
				calendar.add(Calendar.DATE, quantidadeDia);
				calcDate = calendar.getTime();
			}
			
			req.setAttribute("result", sdf.format(calcDate));
			req.getRequestDispatcher("datatime.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
