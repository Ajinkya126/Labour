package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.errorprone.annotations.FormatMethod;

import testbase.TestBase;

public class LoginPage extends TestBase {
	
	// Page Object Model :- design pattern(encapsulation partially)

	//Page Object
	//Login
	@FindBy(id = "txtemail")
	WebElement username;
	@FindBy(id = "txtpass")
	WebElement password;
	@FindBy(id = "Submit")
	WebElement submit;
	
	//LoginHelp
	@FindBy(id = "hlnkHelp")
	WebElement loginhelp;
	
	
	//Actions  
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}
	
	public void loginHelp() {
		loginhelp.click();
	}
	
	 //WebElement Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}



