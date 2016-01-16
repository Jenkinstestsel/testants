package generic_library;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Base_Class {
	public WebDriver driver ;
	public String tBrowser;
	@Parameters({"browser"})
	@BeforeMethod
		public void Initialize_browser(String  Browsertype) throws Exception
	{
//		String Browsertype="chrome";
		tBrowser=Browsertype;
		
		if (Browsertype.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (Browsertype.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browsertype.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"E:/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get("http://books.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void tear_down()
	{
		driver.quit();
	}
	
	public void getscreenshot(Logger log) throws Exception{
		Date date= new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.out.println("hola");
//		File file= new File(dateFormat.format(date) +".png");
		log.info(dateFormat.format(date) +".png");
//		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		BufferedImage  fullImg = ImageIO.read(screenshot);
//		//Get the location of element on the page
//		Point point = ele.getLocation();
//		//Get width and height of the element
//		int eleWidth = ele.getSize().getWidth();
//		int eleHeight = ele.getSize().getHeight();
//		//Crop the entire page screenshot to get only element screenshot
//		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
//		    eleHeight);
//		ImageIO.write(eleScreenshot, "png", screenshot);
//		//Copy the element screenshot to disk
//		FileUtils.copyFile(screenshot, new File("c:\\images\\GoogleLogo_screenshot.png"));
//		
	}

}
