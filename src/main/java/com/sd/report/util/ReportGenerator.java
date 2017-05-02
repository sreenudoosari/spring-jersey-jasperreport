package com.sd.report.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sd.report.beans.LetterDTO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class ReportGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);
	
    public void generatePdfLetterReport(LetterDTO letterDTO) throws JRException {
    	LOGGER.info("generatePdfReport");
        String report = "src/main/resources/report.jrxml";
        JasperReport jreport = JasperCompileManager.compileReport(report);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(letterDTO.getListeData());
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ReportTitle", letterDTO.getTitle());
        params.put("SubTitle", letterDTO.getSubTitle());
        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, ds);
        JasperExportManager.exportReportToPdfFile(jprint,"src/main/resources/report.pdf");
        LOGGER.info("report generated");
    }

    
    
}