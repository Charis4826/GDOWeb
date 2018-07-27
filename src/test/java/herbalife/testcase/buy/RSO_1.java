package herbalife.testcase.buy;

import org.testng.annotations.*;
import herbalife.testcase.lib.Configuration;
import herbalife.testcase.login.Login;
import herbalife.testcase.login.Logout;

public class RSO_1 {
	Configuration rc = new Configuration(Configuration.getFilePath());

	@Test
	public void f() {

	}

	@BeforeClass
	public void beforeTest() {
		// login
		Login login = new Login();
		try {
			login.login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterTest() {
		// Logout
		Logout logout = new Logout();
		logout.logout();
	}

}
