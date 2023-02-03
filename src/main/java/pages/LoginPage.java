package pages;

import org.openqa.selenium.Alert;
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
	
	//Forgot Password
	@FindBy(id = "lbtResetPassword")
	WebElement forgotpwd;
	@FindBy(id = "txtResetPasswordUserID")
	WebElement textbox;
	@FindBy(id = "btnProceed")
	WebElement procedbtn;
	
	//account locked
	@FindBy(id = "lbtUnlockAccount")
	WebElement actlocked;
	@FindBy(id = "txtUnlockAccountUserID")
	WebElement ultextbox;
	@FindBy(id = "btnProceed")
	WebElement ul_submit;
	
	//GmailLogin
	@FindBy(xpath = "//span[normalize-space()='Google']")
	WebElement googlelogin;
	
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
	
	public void forgotPwd(String email) throws InterruptedException {
		forgotpwd.click();
		textbox.sendKeys(email);
		procedbtn.click();
	}
	
	public void accountLocked(String email) throws InterruptedException {
		actlocked.click();
		ultextbox.sendKeys(email);
		ul_submit.click();
	}
	
	public void gmailLogin() {
		googlelogin.click();
	}
	
	 //WebElement Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}



