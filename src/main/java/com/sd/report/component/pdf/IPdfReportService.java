package com.sd.report.component.pdf;

import java.util.List;

import com.sd.report.beans.DataBean;

public interface IPdfReportService {

	List<DataBean> generatePdfData();
}
