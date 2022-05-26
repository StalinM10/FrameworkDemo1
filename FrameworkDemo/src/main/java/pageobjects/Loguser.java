package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loguser {
	
	
	WebDriver driver;
	
	public Loguser(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement username;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement login;
	
	
	public WebElement username() {
		return username;
	}

	public WebElement password() {
		return password;
	}
	
	public WebElement login() {
		return login;
	}
}

