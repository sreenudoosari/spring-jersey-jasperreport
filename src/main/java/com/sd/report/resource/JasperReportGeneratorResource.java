package com.sd.report.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.report.beans.LetterDTO;
import com.sd.report.component.pdf.IPdfReportService;
import com.sd.report.util.ReportGenerator;

import net.sf.jasperreports.engine.JRException;

@Component
@Path("/reports")
public class JasperReportGeneratorResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JasperReportGeneratorResource.class);

	@Autowired
	private IPdfReportService pdfReportService;
	
	@Autowired
	private ReportGenerator reportGenerator;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response generateJasperPdfReportWithDatFromDataBase() {
		LOGGER.info(">>> generateJasperPdfReportWithDatFromDataBase");
		ResponseBuilder responseBuilder;
		try {
			LetterDTO letterDTO = new LetterDTO();
			letterDTO.setTitle("Letter Title");
			letterDTO.setSubTitle("Sub Title");
			letterDTO.setListeData(pdfReportService.generatePdfData());
			reportGenerator.generatePdfLetterReport(letterDTO);
			responseBuilder = Response.status(Status.OK);
		} catch (JRException e) {
			LOGGER.error(">>> generateJasperPdfReportWithDatFromDataBase. Exception :",e);
			responseBuilder = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		return responseBuilder.build();
	}
	
	
	@POST
	public Response generateJasperReportUsingDataPassedAsParameters(LetterDTO letterDTO){
		LOGGER.info(">>> generateJasperReportUsingDataPassedAsParameters");
		ResponseBuilder responseBuilder;
		try {
			reportGenerator.generatePdfLetterReport(letterDTO);
			responseBuilder = Response.status(Status.OK);
		} catch (JRException e) {
			LOGGER.error(">>> generateJasperPdfReportWithDatFromDataBase. Exception :",e);
			responseBuilder = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		return responseBuilder.build();
	}

}
