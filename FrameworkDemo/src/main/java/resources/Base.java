package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;


@SuppressWarnings("unused")
public class Base {
	
	WebDriver driver;
	public  Properties prop;
	@SuppressWarnings("deprecation")

	public WebDriver initializeDriver() throws IOException {
		
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\stalin\\git\\FrameworkDemo1\\FrameworkDemo\\src\\main\\java\\resources\\Properties");
		 prop.load(fis);
		 
		 String browsername = prop.getProperty("browser");
		 
		 if(browsername.equalsIgnoreCase("chrome"))
		 {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 
		 else if (browsername.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		 }
		 
		 else if (browsername.equalsIgnoreCase("IE"))
		 {
			 WebDriverManager.iedriver().setup();
			  driver = new InternetExplorerDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 return driver;
		 
		 
	}
	
	public String takescreenshot(String testname,WebDriver driver ) throws IOException {
		
		File filesource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sspath = System.getProperty("user.dir")+"\\screenshots\\"+testname+".png";
		FileUtils.copyFile(filesource,new File(sspath))	;
		
		return sspath;
	}
	
}
