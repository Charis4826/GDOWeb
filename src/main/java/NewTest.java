import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	 private WebDriver driver;
	 protected DesiredCapabilities capabilities;
	 
  @Test
  public void open() {
	  driver.get("http://www.baidu.com");
      System.out.println("heloo");
      By inputBox = By.id("kw");
      By searchButton = By.id("su");
      //���ܵȴ�Ԫ�ؼ��س���
      intelligentWait(driver, 10, inputBox);
      //���ܵȴ�Ԫ�ؼ��س���
      intelligentWait(driver, 10, searchButton);
      driver.findElement(inputBox).sendKeys("�й���ͼ");
      driver.findElement(searchButton).click();
  }
  @BeforeTest
  public void beforeTest() {
	  capabilities = DesiredCapabilities.chrome();
      capabilities.setBrowserName("chrome");
      System.setProperty("webdriver.chrome.driver", getClass().getResource("/chromedriver.exe").getPath());
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      driver = new ChromeDriver(capabilities);
      driver.manage().window().maximize();
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
  
  /**�������ܵȴ�Ԫ�ؼ��صķ���*/
  public void intelligentWait(WebDriver driver,int timeOut, final By by) {
      try {
          (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>(){
              public Boolean apply(WebDriver driver) {
                  WebElement element = driver.findElement(by);
                  return element.isDisplayed();
              }
          });
      } catch (TimeoutException e) {
          Assert.fail("��ʱL !! " + timeOut + " ��֮��û�ҵ�Ԫ�� [" + by + "]", e);
      }
  }

}