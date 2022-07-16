package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader excelRead = new ExcelReader("src\\main\\java\\testData\\TF_TEST_DATA.xlsx"); // here we created object of ExcelReader class to the method of ExcelReader constructor
	String userName = excelRead.getCellData("longinInfo", "UserName", 2);
	String password = excelRead.getCellData("longinInfo", "Password", 2);
	
	

	public void validUserShouldBeAbleToLogin() {
		BrowserFactory.init();
		LoginPage loginPage = PageFactory .initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
	}
}
