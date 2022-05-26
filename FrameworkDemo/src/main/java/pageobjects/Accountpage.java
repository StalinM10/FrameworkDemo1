package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	
	WebDriver driver;
	
	public Accountpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	WebElement edityourinformation;
	
	public WebElement edityourinformation() {
		return edityourinformation;
	}

}
