package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.Tablets;
import resources.Base;

public class Cartpage extends Base {
	
	WebDriver driver;
	@Test
	public void Tabletsincart() {
		
		Tablets tablets = new Tablets(driver);
		tablets.tabletsmenu().click();
		tablets.addtocart().click();
		tablets.shoppingcart().click();
		
		tablets.quantity().click();
		tablets.quantity().clear();
		tablets.quantity().sendKeys("4");
		tablets.update().click();
		
		tablets.remove().click();
		Assert.assertEquals(tablets.cartisempty().isDisplayed(), true); 
				
	}
	
	@BeforeMethod
	public void open2() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
}
	@AfterMethod
	public void closure2() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		
	}
}
