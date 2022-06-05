package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tablets {
	WebDriver driver;
	
	public Tablets(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']//a[text()='Tablets']")
		private WebElement tabletsmenu;
		
		@FindBy(xpath="//div[@class='button-group']//span[text()='Add to Cart']")
		private WebElement addtocart;
		
		@FindBy(xpath="//div[@id='top-links']//span[text()='Shopping Cart']")
		private WebElement shoppingcart;
		
		@FindBy(xpath="//input[@class='form-control']")
		private WebElement quantity;
		
		@FindBy(xpath="//button[@type='submit'][@class='btn btn-primary']")
		private WebElement update;
		
		@FindBy(xpath="//button[@type='button'][@class='btn btn-danger']")
		private WebElement remove;
		
		@FindBy(xpath="//div[@id='content']/p[text()='Your shopping cart is empty!']")
		private WebElement cartisempty;
		
		public WebElement tabletsmenu() {
			return tabletsmenu;
		}
		
		public WebElement addtocart() {
			return addtocart;
		}
		
		public WebElement shoppingcart() {
			return shoppingcart;
		}
		
		public WebElement quantity() {
			return quantity;
		}
		
		public WebElement update() {
			return update;
		}
		
		public WebElement remove() {
			return remove;
		}
		
		public WebElement cartisempty() {
			return cartisempty;
		}
		}
		
		
		
		
		
	


