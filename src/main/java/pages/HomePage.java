package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class HomePage extends TestBase {
	
	//page object
	
		@FindBy(css = ".fa.fa-power-off")
		WebElement logoutbtn;
		
		@FindBy(id = "btnAddUser")	//user btn
		WebElement userbtn;
		
		@FindBy(id = "btnAddCustomer") //btnAddCustomer
		WebElement corporatebtn;
		
		
		// actions
		public void clickOnlogout() {
			logoutbtn.click();
		}
		
		public UserPage click_on_user() {
			userbtn.click();
			return new UserPage();
		}
		
		public CorporatePage click_on_corporate_btn() {
			corporatebtn.click();
			return new CorporatePage();
		}
		
		
			// initialization
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

}
