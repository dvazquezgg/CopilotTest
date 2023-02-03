package mx.edu.greengates.activities.report;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

import java.util.HashMap;
import java.util.Map;

public class Reports {

    String templatePath;
    String csvFile;
    String pdfFile;

    public static void main(String[] args) {

        String templatePath = "report\\report1.jrxml";
        String csvFile = "report\\report1.csv";
        String pdfFile = "report\\report1.pdf";
        Reports reports = new Reports(templatePath, csvFile, pdfFile);
        reports.generateReport();
    }

    public Reports(String templatePath, String csvFile, String pdfFile) {
        this.templatePath = templatePath;
        this.csvFile = csvFile;
        this.pdfFile = pdfFile;
    }

    public void generateReport(){

        try {
            // Load the report template
            JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);

            // Load the csv data into a JRDataSource
            JRCsvDataSource dataSource = new JRCsvDataSource(csvFile);

            Map<String, Object> parameters = new HashMap<String, Object>();

            // Fill the report using the data source and the template
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the filled report to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFile);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
