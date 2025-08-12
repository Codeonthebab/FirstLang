package com.chart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

@WebServlet("/FileChartServlet")
public class FileChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터 생성
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Son-Ogong", 63.2);
		dataset.setValue("Jer-PalGae", 37.9);
		dataset.setValue("Sa-OJung", 29.4);
		
		// 2. 차트를 생성
		JFreeChart chart = ChartFactory.createPieChart("Energy Power",
				dataset, true, true, false);
		
		// 3. 차트를 출력
		ServletOutputStream out = response.getOutputStream();
		ChartUtilities.writeChartAsPNG(out, chart, 400, 400);
		
	}
}
