package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import util.Utility;

public class UserPage extends TestBase {
	UserPage userpage;
	
	@FindBy(id = "btnAdd")
	WebElement addNewBtn;
	
	@FindBy(css = ".k-content-frame") //fn and ln is in frame
	WebElement frame;
	
	@FindBy(id = "tbxFirstName")
	WebElement firstName;
	
	@FindBy(id = "tbxLastName")
	WebElement lastName;
	
	@FindBy(id = "btnSave")
	WebElement savebtn;
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]")
	WebElement editbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Search User Name/Email')]")
	WebElement searchbar;
	@FindBy(xpath = "//input[@role='listbox']")   
	WebElement search;   // dropdown
	@FindBy(xpath = "//ul[@id='ddlUser_listbox']/child::li")
	WebElement list;
	@FindBy(id = "btnApply")
	WebElement applybtn;
	
	@FindBy(id = "btnClear")
	WebElement clearbtn;
	
	
	@FindBy(xpath = "(//a[@role='button'])[3]")
	WebElement resetbtn;
	
	
	@FindBy(xpath = "//a[@class='k-button k-button-icontext k-grid-delete']")
	WebElement deletebtn;
	@FindBy(css = ".k-button.k-primary")
	WebElement confirmokbtn;
	@FindBy(css = "button[class='k-button']")
	WebElement okbtn;
	
	@FindBy(css = "button[class='k-button']")
	WebElement cancelbtn;
	
	// Pagination
	@FindBy(xpath = "//a[normalize-space()='2']")
	WebElement pagenave2;
	@FindBy(xpath = "//a[normalize-space()='3']")
	WebElement pagenave3;
	@FindBy(css = ".k-icon.k-i-arrow-60-right")
	WebElement rightnav;
	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-end-right']")
	WebElement lastnav;
	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-end-left']")
	WebElement firstnav;
	
	//Back button
	@FindBy(id = "btnBack")
	WebElement backbtn;

	public void userSaveBtn(String fn, String ln) {
		addNewBtn.click();
//		Utility.switchToFrame(driver.findElement(By.cssSelector(".k-content-frame")));  //Element is in frame
		Utility.switchToFrame(frame);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		savebtn.click();
	}
	
	public void userEditBtn(String fn, String ln) {
		editbtn.click();
	//	Utility.switchToFrame(driver.findElement(By.cssSelector(".k-content-frame")));  //Element is in frame
		Utility.switchToFrame(frame);
		firstName.clear();
		lastName.clear();
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		
		savebtn.click();
		}
	
	
	public void searchBar() throws InterruptedException {  //Dynamic Dropdown
		searchbar.click();
		search.sendKeys("Ajinkya");
		Thread.sleep(3000);
	//	Utility.dyanamicDropDown("list", "Ajinkya k");
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
		
		for(int i=0; i<options.size(); i++) {
			String webelementText = options.get(i).getText();
			
			if(webelementText.contains("Ajinkya k")) {
				options.get(i).click();
			}
		}
		applybtn.click();
	}
	
	
	public void clearBtn() throws InterruptedException {
		userpage = new UserPage();   //Object of userpage
		userpage.searchBar();
		Thread.sleep(3000);
		
		clearbtn.click();
	}
	
	
	public void reset() {
		resetbtn.click();
	}
	
	
	public void delete() throws InterruptedException {
		userpage = new UserPage();     // Object of userpage
		userpage.searchBar();
		
		deletebtn.click();
		confirmokbtn.click();
		Thread.sleep(2000);
	//	okbtn.click();
	}
	
	
	public void cancel() throws InterruptedException {
		userpage = new UserPage();     // Object of userpage
		userpage.searchBar();
		
		deletebtn.click();
		Thread.sleep(2000);
		cancelbtn.click();
	}
	
	public void pagination() throws InterruptedException {
		pagenave2.click();
		Thread.sleep(1000);
		pagenave3.click();
		Thread.sleep(1000);
		rightnav.click();
		Thread.sleep(1000);
		lastnav.click();
		Thread.sleep(1000);
		firstnav.click();
	}
	
	public HomePage backBtn() {
		backbtn.click();
		return new HomePage();
	}

	
	
	public UserPage() {
		PageFactory.initElements(driver, this);
	}
	
}
