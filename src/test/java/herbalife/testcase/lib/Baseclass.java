package herbalife.testcase.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.internal.BaseClassFinder;

public class Baseclass extends BaseClassFinder {

	public static WebDriver driver;
	public static String currentWindow;
	public static DesiredCapabilities capabilities;
	public static Configuration rc = myConfigHelper.getConfig();

	public static WebDriver getDriver() {
		return driver;
	}

	public static String log(String info) {
		System.out.println(info + "\n");
		return info;
	}

	public static void openbrowser(String browser, String url) {
		String userDir = System.getProperty("user.dir");

		if (browser.toUpperCase().equals("IE")) {
			File file = new File(userDir + "/src/main/resources/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

			driver = new InternetExplorerDriver();
		} else if (browser.toUpperCase().equals("CHROME")) {

			File file = new File(userDir + "/src/main/resources/chromedriver2.29.461591.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

			capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName(browser);
			ChromeOptions options = new ChromeOptions();

			options.addArguments(
					"--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");
			options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
		} else if (browser.toUpperCase().equals("FIREFOX")) {
			File file = new File(userDir + "/src/main/resources/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

			driver = new FirefoxDriver();
		}

		driver.get(url);
		Baseclass.log("open browser:" + browser + " and input testURL:" + url);
	}

	// opration the windows max
	public static void maxwindow() {
		driver.manage().window().maximize();
		Baseclass.log("max windows");
	}

	// refresh the windows
	public static void refresh() {
		driver.navigate().refresh();
		Baseclass.log("refresh the windows");
	}

	public static void login(String browser, String url, String username, String pwd) throws InterruptedException {
		Baseclass.openbrowser(browser, url);
		Baseclass.wait(2);
		Baseclass.maxwindow();
		Baseclass.sendkeys("username", username);
		Baseclass.sendkeys("pwd", pwd);
		Baseclass.click("loginbtn");
		Baseclass.log("登陆账号为:" + username + " " + "登陆密码为:" + pwd);
	}

	public static void closebrowser() {
		String Browser = rc.getValue("browser");
		if (Browser != null) {
			if (Browser.toUpperCase().equals("CHROME")) {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
					driver.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Browser.toUpperCase().equals("IE")) {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Browser.toUpperCase().equals("FIREFOX")) {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void click(String key) throws InterruptedException {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		if (element.getText() != null && !"".equals(element.getText())) {
			String text = element.getText();
			Thread.sleep(1000);
			System.out.println("execute click operation:");
			System.out.println("click" + " " + text);
		} else if ("".equals(element.getText())) {
			Thread.sleep(1000);
			System.out.println("execute click operation");
			System.out.println("click" + " " + key);
		} else {
			System.out.println("this Element is not found text");
		}
		element.click();
	}
	
	public static void switchToIframe(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		driver.switchTo().frame(element);
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void inputToRichTextBox(String key, String key2, String value) {
		Locator Locate = new Locator();
		switchToIframe(key);
		List<WebElement> aa = Locate.getElements(key2);
		aa.get(1).clear();
		aa.get(1).sendKeys(value);
		Baseclass.log("Input" + " " + value + " " + "to Content");
	}

	// find element and set the value
	public static void sendkeys(String key, String str) throws InterruptedException {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		element.clear();
		Thread.sleep(1000);
		element.sendKeys(str);
		// Br.log("execute select element object"+text);
		Baseclass.log("Set: " + str);
	}
	/*
	 * public static void click(String key) throws InterruptedException{ Locator
	 * Locate = new Locator(); WebElement element = Locate.getElement(key); String
	 * text; if(element.getText()!=null && ! "".equals(element.getText())){
	 * if(element.getText()!=null ){ text=element.getText(); Thread.sleep(1000);
	 * System.out.println("execute click operation");
	 * System.out.println("click"+" "+text); } else
	 * if(!"".equals(element.getAttribute("value"))){
	 * text=element.getAttribute("value"); Thread.sleep(1000);
	 * System.out.println("execute click operation");
	 * System.out.println("click"+" "+text); } else{
	 * System.out.println("this Element is not found text"); } element.click();} }
	 */



	public static void confirmDialog() throws InterruptedException {
		Alert confirmDialog = driver.switchTo().alert();
		confirmDialog.accept();
		Thread.sleep(1000);
		System.out.println("confirm dialog");
	}

	public static void clickElementNo(String key, int num) throws InterruptedException {
		Locator Locate = new Locator();
		List<WebElement> aa = Locate.getElements(key);
		aa.get(num).click();
		log(key + " " + "was clicked");
	}

	/*
	 * doubleclick
	 * 
	 * @ by
	 */
	public static void doubleClick(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		new Actions(driver).doubleClick(element).doubleClick();
	}

	public static void clear(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		element.clear();
		Baseclass.log("Empty element content，by: " + element);
	}
	/*
	 * select element by index webdriver is nonsupport select function,so suggest
	 * not
	 */

	public static void selectByIndex(String key, int index) {
		// driver.findElement(by).click();
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		String text;
		Select select = new Select(element);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		select.selectByIndex(index);
		Baseclass.log("Perform a drop-down box operations，operation element：" + key);
		text = element.getText();
		Baseclass.log("select" + index + "element" + "element info is:" + text);
	}

	/*
	 * select element by value webdriver is nonsupport select function,so suggest
	 * not
	 */
	public static void selectByText(String key, String text) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/*
	 * select element by linktext webdriver is nonsupport select function,so suggest
	 * not
	 */
	public static void selectByLinkText(String key, String LinkText) {
		// driver.findElement(by).click();
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		Select select = new Select(element);
		select.selectByValue(LinkText);
		Baseclass.log("execute select element ，the object：" + LinkText);
	}

	public static void inputToRichTextBox(String key, String value) {
		switchToIframe(key);
		List<WebElement> aa = driver.findElements(By.className("view"));
		// aa.get(0).sendKeys(Keys.TAB);
		aa.get(1).clear();
		aa.get(1).sendKeys(value);
		Baseclass.log("set" + value);
	}

	// 获取链接元素的url值…………………………
	public static String getLinkUrl(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		return element.getAttribute("href");
	}

	// 判断某个元素是否存在
	public static boolean isElementExist(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		try {
			Boolean bool = element.isDisplayed();
			Baseclass.log("execute" + element + "exist or not" + "," + "result is ：" + bool);
			return bool;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	 /**这是智能等待元素加载的方法*/
    public static void intelligentWait(int timeOut, final String key) {
    	Locator Locate = new Locator();
		
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>(){
                public Boolean apply(WebDriver driver) {
                	WebElement element = Locate.getElement(key);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + key + "]", e);
        }
    }

	// 获得某元素的文本描述信息
	public static String getWebText(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		String text;
		text = element.getText();
		try {
			Baseclass.log("get Element text " + ":" + text);
			return text;
			// return driver.findElement(by).getText();
		} catch (NoSuchElementException e) {
			return "not found the Element text!";
		}
	}

	/*
	 * 在一个元素集合中通过遍历文本内容定位到相应的元素
	 */
	public static boolean elementContainingText(String key, String text) {
		Locator Locate = new Locator();
		List<WebElement> elements = Locate.getElements(key);
		String actualResult = elements.get(0).getText();
		log("Actual:" + " " + actualResult + "\n\r" + "Expected:" + " " + text);
		return actualResult.contains(text);
	}

	/*
	 * 根据id定位元素并获取元素的选中状态
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public static boolean getselectstat(String key) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		boolean flag = true;
		if (flag) {
			Baseclass.log("页面元素状态：" + element + "已被选中");
			return element.isSelected();
		} else {
			Baseclass.log("页面元素状态：" + element + "未被选中");
			return false;
		}
	}

	/*
	 * 等待时间
	 * 
	 * @param second
	 * 
	 * @return
	 * 
	 * public static boolean wait(int second){
	 * try{driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	 * Thread.sleep(2000); Baseclass.log("执行了等待操作，等待了"+second+"秒"); return true; }
	 * catch(Exception e) { return false; } }
	 */
	public static boolean wait(int second) {
		try {
			Thread.sleep(second * 1000);
			Baseclass.log("execute wait operation, wait for " + second + " " + "seconds");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//          public static void waitForpageToload(int i){
//        	  boolean isLoaded=false;  
//              int count=0;  
//              do{  
//                  if(count++>3){  
//                      break;  
//                  }  
//                  try{  
//                      selenium.waitForPageToLoad(i);  
//                      isLoaded=true;  
//                  }catch(Exception ex){  
//                      continue;  
//                  }  
//              }while(!isLoaded);  
//          }  
//          
//          

	// 通过弹出框的title进行切换，非xpath等方法，此方法比较方便
	public static boolean switchtobytitle(String windowTitle) {
		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle)) {
					// System.out.println("test here");
					continue;
				} else {
					driver.switchTo().window(s);
					if (driver.getTitle().contains(windowTitle)) {
						flag = true;
						System.out.println("切换窗口到:" + windowTitle);
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.printf("Window: " + windowTitle + " cound not found!", e.fillInStackTrace());
			flag = false;
		}
		return flag;
	}

	/*
	 * 通过windows的id号进行切换
	 * 
	 * @i 窗口的索引从0开始
	 * 
	 * @by driver的查找元素方式
	 */
	public static void switchto(String key) throws InterruptedException {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		element.click(); // pop up windows before opration
		Thread.sleep(3000);
		int sizes;
		sizes = driver.getWindowHandles().size();
		System.out.println("get the windows size:" + "  " + sizes);
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		Thread.sleep(3000);
		Baseclass.log("begin switching windows");
		// driver.findElement(by).click();
		driver.switchTo().window(handles[sizes]);
		Baseclass.log("complete switched windows");

	}

	public static boolean verifyForm(String key, String text) {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		String data;
		data = element.getText();
		if (data.equals(text)) {
			Baseclass.log("actual result: " + data + "expected result: " + text + "  equal");
			return true;
		} else {
			Baseclass.log("actual result: " + data + "expected result: " + text + " disaffinity");
			return false;
		}
	}

	public static void SetClassName(String key, String value) throws InterruptedException {
		Locator Locate = new Locator();
		WebElement element = Locate.getElement(key);
		System.out.println("The class name before change is:" + element.getAttribute("class"));
		String js = "document.getElementsByClassName('checkbox')[0].className='" + value + "'";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(js);
		System.out.println("The class name after change is:" + element.getAttribute("class"));
	}
}
