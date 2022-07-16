package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage( WebDriver driver) { //here we create constructor to make link the driver to be same
		this.driver = driver;
		
	}
	//Element list
	//	WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
//	By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
	//Above method for elements not working for POM(Page Object Model) we need use this: @FindBy(how = using)
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_ELEMENT;
//There is 2 ways to Make Intractable Methods 1- make methods individually 2- make one method for all elements
	
	//intractable methods
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
		
		public void insertPassword(String password) {
			PASSWORD_ELEMENT.sendKeys(password);
		}
		 
		public void clickSigninButton() {
			SIGNIN_ELEMENT.click();
		}
		
	}
	
