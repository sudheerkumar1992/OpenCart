package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	 public static WebDriver driver;
	 public Logger logger;//log4j
	 public Properties pro;

	@BeforeClass(groups={"Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
		
		FileInputStream fis=new FileInputStream("F:\\EclipsData\\OpenCart\\src\\test\\resources\\config.properties");
		pro=new Properties();
		pro.load(fis);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		case "edge":driver = new EdgeDriver();break;
		default:System.out.println("Invalid browser");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups={"Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() {
		String randomAlp = RandomStringUtils.randomAlphabetic(5);
		return randomAlp;
	}

	public String randomNumber() {
		String randomNum = RandomStringUtils.randomNumeric(10);
		return randomNum;
	}

	public String randomAlphaNumeric() {
		String randomAlp = RandomStringUtils.randomAlphabetic(3);
		String randomNum = RandomStringUtils.randomNumeric(3);
		return (randomAlp + "@" + randomNum);
	}
	public String captureScreen(String tname)throws IOException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("F:\\EclipsData\\OpenCart\\screenshots"+tname+""+timeStamp+".png");
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
