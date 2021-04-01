package my.model.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportsGenerateService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String REPORT_FOLDER = "WEB-INF/classes/my/model/reports/";

	public static String reportGenerate(Collection<?> collection, String reportJrxmlName, String reportOutName,
			String type, ServletContext context) throws JRException, FileNotFoundException {
		JRBeanCollectionDataSource dataList = new JRBeanCollectionDataSource(collection);

		File file = new File(context.getRealPath(REPORT_FOLDER) + reportJrxmlName + ".jrxml");
		InputStream is = new FileInputStream(file);
		JasperReport reportFile = JasperCompileManager.compileReport(is);

		JasperPrint print = JasperFillManager.fillReport(reportFile, null, dataList);

		String reportPath = context.getRealPath(REPORT_FOLDER) + reportOutName.concat("." + type);

		File generatedFile = new File(reportPath);

		if (type.equals("pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();
			ExporterInput ei = new SimpleExporterInput(print);
			exporter.setExporterInput(ei);
			OutputStreamExporterOutput eo = new SimpleOutputStreamExporterOutput(generatedFile);
			exporter.setExporterOutput(eo);
			exporter.exportReport();
		} else if (type.equals("xlsx")) {
			JRXlsxExporter exporter = new JRXlsxExporter();
			ExporterInput ei = new SimpleExporterInput(print);
			exporter.setExporterInput(ei);
			OutputStreamExporterOutput eo = new SimpleOutputStreamExporterOutput(generatedFile);
			exporter.setExporterOutput(eo);
			exporter.exportReport();
		}
		generatedFile.deleteOnExit();
		return generatedFile.getAbsolutePath();
	}
}
