package my.controller.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.controller.services.ListUsers;
import my.model.entities.User;
import my.model.reports.ReportsGenerateService;
import net.sf.jasperreports.engine.JRException;

@WebServlet("/pages/reports")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		List<User> list = new ListUsers().listAll();
		
		try {
			String toDownloadFileDir = ReportsGenerateService.reportGenerate(list, "users_report", "relatorio-de-usuarios", type,
					req.getServletContext());
			
			File toDownloadFile = new File(toDownloadFileDir);
			FileInputStream fis = new FileInputStream(toDownloadFile);

			String mimeType = req.getServletContext().getMimeType(toDownloadFile.getAbsolutePath());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename = " + toDownloadFile.getName();

			resp.setContentType(mimeType);
			resp.setContentLength((int) toDownloadFile.length());
			resp.setHeader(headerKey, headerValue);

			OutputStream ops = resp.getOutputStream();
			byte[] buffer = new byte[1024];
			int readedBytes = -1;

			while ((readedBytes = fis.read(buffer)) != -1) {
				ops.write(buffer, 0, readedBytes);
			}
			fis.close();
			ops.close();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
