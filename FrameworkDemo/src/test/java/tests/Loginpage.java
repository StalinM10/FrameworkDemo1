package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Accountpage;
import pageobjects.LandingPage;
import pageobjects.Loguser;
import resources.Base;

public class Loginpage extends Base  {

	public WebDriver driver;
	@Test(dataProvider = "getlogindata")
	public void login(String email,String password,String Expectedresult) throws IOException {
	
		LandingPage landingpage = new LandingPage(driver);
		landingpage.myaccountdropdown().click();
		landingpage.loginoption().click();
		
	    Loguser loguser = new Loguser(driver);
	    loguser.username().sendKeys(email);
	    loguser.password().sendKeys(password);
	    loguser.login().click();
	    
	    Accountpage accountpage = new Accountpage(driver);
	    String actualresult = null;
	    try {
	    if(accountpage.edityourinformation().isDisplayed()) {
	    	actualresult = "Sucessfull";
	    }
	    }
	    catch(Exception e) {
	    	actualresult = "Failure";
	    }
	    
	    Assert.assertEquals(actualresult, Expectedresult);
	}
	@BeforeMethod
	public void open1() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
	}
	@DataProvider
	public Object[][] getlogindata() {
		Object[][] data = {{"stalinmlmrma@gmail.com","9092707696","Sucessfull"},{"dummy@test.com","12356460","Failure"}};
		return data;
		
		
	}

	
}
