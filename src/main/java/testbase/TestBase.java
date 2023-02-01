package testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Madhu Kumbhar\\eclipse-workspace\\LabourCompliance\\src\\main\\java\\environment_data\\config.properties");
			prop.load(file);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(prop.getProperty("url"));
	}

}
