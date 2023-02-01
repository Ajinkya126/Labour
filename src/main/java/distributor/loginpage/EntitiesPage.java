package distributor.loginpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class EntitiesPage extends TestBase {
	
	//WebElement
	@FindBy(id = "txtSearch")
	WebElement searchbox;
	
	//@FindBy(xpath = "//body[1]/form[1]/div[3]/section[1]/section[1]/header[1]/div[2]/ul[1]/li[3]/a[1]/i[1]")
	//WebElement logout;
	
	@FindBy(id = "ContentPlaceHolder1_btnEntityLocationExport")
	WebElement entity_location_btn;
	
	@FindBy(id = "ContentPlaceHolder1_btnEntityExport")
	WebElement entity_btn;
	
	@FindBy(xpath = "//*[@id='sidebar']/div[1]/a")
	WebElement TLlogo;
	
	//Action
	public void entities_search(String search_txt) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		searchbox.sendKeys(search_txt);
	}
	
	public void entitylocation_exceldowld() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		entity_location_btn.click();
	}
	
	public void entity_exceldowld() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		entity_btn.click();
	}
	
	
	public void logo() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By locator2 = By.xpath("//*[@id='togglediv']/div");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
		WebElement ViewButton2 = driver.findElement(locator2);	
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", ViewButton2);
		jse2.executeScript("arguments[0].click();", ViewButton2);
		Thread.sleep(4000);
		if(TLlogo.isDisplayed()) {
			System.out.println("Logo is present");
		}
		else {
			System.out.println("Logo is not present");
		}
		
	}
	
	public void logout_action() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By logoutbtn = By.xpath("//body[1]/form[1]/div[3]/section[1]/section[1]/header[1]/div[2]/ul[1]/li[3]/a[1]/i[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutbtn));
		WebElement logoutButton = driver.findElement(logoutbtn);	
		JavascriptExecutor jse1=(JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click();", logoutButton);
		//since the DOM has changed for logout btn so driver was giving an error, so for that repeated the webelement define n click action again.- solution bookmarked
	}
	
	public void proceedbtn_click(String entity_search_text) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchbox.sendKeys(entity_search_text);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By proceed_btn = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]/a/img");
		wait.until(ExpectedConditions.presenceOfElementLocated(proceed_btn));
		WebElement proceedButton = driver.findElement(proceed_btn);	
		JavascriptExecutor jse3=(JavascriptExecutor)driver;
		jse3.executeScript("arguments[0].click();", proceedButton);
	}
	
	public EntitiesPage() {
		PageFactory.initElements(driver, this);
	}

}
