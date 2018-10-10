package com.epam.lab.homeWork.dataProviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.epam.lab.homeWork.parsers.CSVParser;
import com.epam.lab.homeWork.parsers.PropertyParser;
import com.epam.lab.homeWork.parsers.XLSXParser;

public class UserDataProvider {
	private final static String PROPERTIES_PATH = "src/test/resources/config.properties";

	@DataProvider(name = "userDataCSV", parallel = true)
	public static Object[][] provideCSV() {
		return CSVParser.parse(new PropertyParser(PROPERTIES_PATH).getProperty("userCSVListPath"));
	}

	@DataProvider(name = "userDataXLSX", parallel = true)
	public static Object[][] provideXLSX(ITestContext context) {
		return XLSXParser.parse(context.getCurrentXmlTest().getParameter("userDataXLSX"));
	}
}