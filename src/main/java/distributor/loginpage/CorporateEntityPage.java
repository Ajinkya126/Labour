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

public class CorporateEntityPage extends TestBase{
	
	//WebElement
	@FindBy(xpath = "//button[@id= 'btnAddCustomer']/span")
	WebElement corporate_btn;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/section[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[2]/span[1]")
	WebElement corporate_search;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/span[1]/input[1]")
	WebElement cp_txt_box;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]")
	WebElement cp_searched_txt;
	
	@FindBy(id = "btnApply")
	WebElement apply_btn;
	
	//@FindBy(xpath = "//*[@id='grid']/div[2]/table/tbody/tr/td[7]/a[3]")
	//WebElement view_entity_arw;
	
	@FindBy(xpath = "//*[@id='treelist']/div[2]/table/tbody/tr[1]/td[5]")
	WebElement selected_entity_todelete;
	
	//@FindBy(xpath = "//*[@id='treelist']/div[2]/table/tbody/tr[1]/td[6]/a[2]")
	//WebElement entity_delete_btn;
	
	@FindBy(id = "ContentPlaceHolder1_lnkTabEntity")
	WebElement entity_tab;
	
	@FindBy(id = "btnBack")
	WebElement backbtn;
	
	//Action
	public void corporate_nsearch() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", corporate_btn);
		//corporate_btn.click();
		corporate_search.click();
		cp_txt_box.sendKeys("TCG demo customer");
		cp_searched_txt.click();
		apply_btn.click();
		Thread.sleep(3000);
	}
	
	public void entity_delete() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By view_entity_arw = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[7]/a[3]");
		wait.until(ExpectedConditions.presenceOfElementLocated(view_entity_arw));
		WebElement ViewButton2 = driver.findElement(view_entity_arw);	
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", ViewButton2);
		jse2.executeScript("arguments[0].click();", ViewButton2);	
		//boolean is_dlt_entity_prsnt = selected_entity_todelete.getText().contains("TCG Auto Test");
		boolean is_dlt_entity_prsnt = driver.getPageSource().contains("TCG Auto Test");
		System.out.println(is_dlt_entity_prsnt);
		if(is_dlt_entity_prsnt == true) {
			
			By entity_delete_btn = By.xpath("//*[@id='treelist']/div[2]/table/tbody/tr[1]/td[6]/a[2]");
			wait.until(ExpectedConditions.presenceOfElementLocated(entity_delete_btn));
			WebElement deleteButton = driver.findElement(entity_delete_btn);	
			JavascriptExecutor jse1=(JavascriptExecutor)driver;
			jse1.executeScript("arguments[0].click();", deleteButton);
			//jse1.executeScript("arguments[0].click();", deleteButton);	
			//entity_delete_btn.click();
		}
		else {
			System.out.println("Entity not found.");
		}
	}
	
	public void back_btn_click() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", corporate_btn);
		entity_tab.click();
		backbtn.click();
	}

	public CorporateEntityPage() {
		PageFactory.initElements(driver, this);

	}
}
