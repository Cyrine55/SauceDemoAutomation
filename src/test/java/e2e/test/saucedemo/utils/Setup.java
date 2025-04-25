package e2e.test.saucedemo.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {
	
	
	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());
	//private static final Logger LOGGER = LogManager.getLogger(Setup.class);
	/**
	 * This method is used to open browser. this method is called before the
	 * invocation of each test method in the given class. In this method we need to pass browser name which will invoke the 
	 * respective driver
	 
	 * @throws MalformedURLExpeption the malformed the urlexception
	 * @Before Methods annotated with @Before will execute before every scenario
	 */
	@Before
	public void setWebDriver(Scenario scenario) {
		LOGGER.info("Scenario: " +scenario.getName() + "- started");
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = "chrome";
		}
		
		switch(browser) {
		case "chrome" :
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
	        chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("start-maximized");
			
			 Map<String, Object> prefs = new HashMap<>();
			    prefs.put("credentials_enable_service", false);
			    prefs.put("profile.password_manager_enabled", false);
			    chromeOptions.setExperimentalOption("prefs", prefs);
			    
			driver = new ChromeDriver(chromeOptions);
			
			break;
			
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("platform", Platform.WIN10);
			driver = new FirefoxDriver (firefoxOptions);
			break;
			
		default:
			throw new IllegalArgumentException("browser" + browser+ "notidentified");
			
		}
	}
	
	/*GETTER : since the driver is static we must create a getter to access a driver in another class*/
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}
	
	
	/*@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		driver.quit();
		LOGGER.info("Scenario: " +scenario.getName() + "- finished.Status" +  scenario.getStatus());
	}*/
	
	
}
