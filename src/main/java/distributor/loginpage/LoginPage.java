package distributor.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase{
	
	//WebElements
	@FindBy(id = "txtemail")
	WebElement username;
	
	@FindBy(id = "txtpass")
	WebElement password;
	
	@FindBy(id = "Submit")
	WebElement submit;
	
	//Action
	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

}
