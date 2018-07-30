package herbalife.testcase.login;

import org.testng.annotations.Test;

import herbalife.testcase.lib.Baseclass;
import herbalife.testcase.lib.Configuration;
import herbalife.testcase.lib.myConfigHelper;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Logout {
	@Test
	public void logout() {

		// Logout
		try {
			Baseclass.intelligentWait(10, "logoutbtn");
			Baseclass.click("logoutbtn");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// close browser
		Baseclass.closebrowser();
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
