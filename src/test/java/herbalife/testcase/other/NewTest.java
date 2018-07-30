package herbalife.testcase.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class NewTest {
	 WebDriver driver;
	 DesiredCapabilities capabilities;
	 
	 @BeforeTest
	 @Parameters({ "para"})
	  public void beforeTest(String para) throws Exception {
		 Properties prop = new Properties();
		 prop.load(new FileInputStream(para));  
		 
		 String drivertype = prop.getProperty("drivertype");
         String driverdetail = prop.getProperty("driverdetail");
         String browser = prop.getProperty("browser");
         
	      System.setProperty(drivertype, getClass().getResource(driverdetail).toURI().getPath());
	      
	      if (browser.toUpperCase().equals("IE")) {
	    	  driver = new InternetExplorerDriver();
	      }else if (browser.toUpperCase().equals("CHROME")) {
	    	  	capabilities = DesiredCapabilities.chrome();
	      		capabilities.setBrowserName(browser);
	      		ChromeOptions options = new ChromeOptions();
	      		
	      		String user = prop.getProperty("user");
	      		
	            options.addArguments(
	          		  "--user-data-dir=C:/Users/"+ user +"/AppData/Local/Google/Chrome/User Data/Default");
	            options.addArguments("--start-maximized","allow-running-insecure-content","--test-type");
	            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	            driver = new ChromeDriver(capabilities);
	      	}else if (browser.toUpperCase().equals("FIREFOX")) {
	      			driver = new FirefoxDriver();
	      		}
	     
	      driver.manage().window().maximize();
	  }
	 
	 
	 @Test
	 public void open() {
		 driver.get("http://www.baidu.com");
		 System.out.println("heloo");
		 By inputBox = By.id("kw");
		 By searchButton = By.id("su");
		 intelligentWait(driver, 10, inputBox);
		 intelligentWait(driver, 10, searchButton);
		 driver.findElement(inputBox).sendKeys("中国地图");
		 driver.findElement(searchButton).click();
	 }
 
	 @AfterTest
	 public void afterTest() {
		 try {
			 //�ȴ�5��鿴ִ��Ч��
			 Thread.sleep(5000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
		 driver.quit();
	 }
  
	 /**这是智能等待元素加载的方法*/
	    public void intelligentWait(WebDriver driver,int timeOut, final By by) {
	        try {
	            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>(){
	                public Boolean apply(WebDriver driver) {
	                    WebElement element = driver.findElement(by);
	                    return element.isDisplayed();
	                }
	            });
	        } catch (TimeoutException e) {
	            Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
	        }
	    }

}
