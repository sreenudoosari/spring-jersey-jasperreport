package com.sd.report.component.pdf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sd.report.beans.DataBean;

@Repository
class PdfReportRepository {

	  @Autowired
	  private JdbcTemplate jtm;

	public List<DataBean> generatePdfData() {
		// call database using the datasource
		//jtm.query(psc, rse)
		return getDataBeanList();
	}

	public ArrayList<DataBean> getDataBeanList() {
		ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
		dataBeanList.add(new DataBean("Josh Long", "France"));
		dataBeanList.add(new DataBean("Dennis", "USA"));
		dataBeanList.add(new DataBean("David", "India"));
		dataBeanList.add(new DataBean("Celia", "California"));
		return dataBeanList;
	}

}
