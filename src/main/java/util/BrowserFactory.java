package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
 static WebDriver driver;
 static String browser; // here we create instance(global) variable to make all variable same
 static String url;
 
 public static void readConfig() {
	 
	 try {
		 InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
//our file is properties and java conn't read it therefore there is Properties class and we use this like below
		 Properties prop = new Properties();
		 prop.load(input); // here what ever it read from "src\\main\\java\\config\\config.properties" it goes to input therefore we add input in load method
		 prop.getProperty("browser"); //here it read the brower from config.properties and to make the browser same as with globle variable we can save it in variable then to make same as global
		 browser = prop.getProperty("browser");
		 prop.getProperty("url"); //we read the url from config.properties and to make same we make it globle variable
		 url = prop.getProperty("url");
		 
		 	 
	 }catch(IOException e) {
		 e.getStackTrace(); 
	 }
 }
 
	public static WebDriver init() {    //here we make the return type method who ever call the method should able to have return value 
		readConfig();
		 if(browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			 
		 }else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe"); 
			// driver = new FirefoxDriver; //my firefox not working
		 }
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
