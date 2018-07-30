package herbalife.testcase.login;

import org.testng.annotations.Test;

import herbalife.testcase.lib.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class Login {

	Configuration rc = myConfigHelper.getConfig();
	/*
	 * @DataProvider(name = "TestData") public static Object[][] getLoginData()
	 * throws IOException { Object[][] obj = TestData.getTestData("data/", "nc.xls",
	 * "login"); return obj; }(dataProvider = "TestData")
	 */

	@Test
	public void login() throws Exception {
		Baseclass.login(rc.getValue("browser"), rc.getValue("url"), rc.getValue("username"), rc.getValue("pwd"));
	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
	}

}
