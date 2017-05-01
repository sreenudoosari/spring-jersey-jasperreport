package com.sd.report.component.pdf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.report.beans.DataBean;

@Service
class PdfReportServiceImpl implements IPdfReportService {

	@Autowired
	private PdfReportRepository pdfReportRepository;
	
	@Override
	public List<DataBean> generatePdfData() {
       return pdfReportRepository.generatePdfData();
	}

}
