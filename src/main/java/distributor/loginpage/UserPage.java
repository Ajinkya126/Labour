package distributor.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class UserPage extends TestBase{
	
	//WebElement
	@FindBy(id = "btnAddUser")
	WebElement userbtn;
	
	//Action
	public void userbtn_action() {
		userbtn.click();
	}
	
	public UserPage() {
		PageFactory.initElements(driver, this);
	}

}
