package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import testbase.TestBase;

public class UserPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	UserPage userpage;
	
	@BeforeMethod
	public void init() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		userpage = homepage.click_on_user();
	}
	
	@Test (priority=1)
	public void validate_save_btn_with_2_mandetory_field() throws InterruptedException {
		userpage.userSaveBtn(prop.getProperty("firstName"), prop.getProperty("lastName"));
		boolean value = driver.findElement(By.id("vsUserDetails")).isDisplayed();
		Assert.assertEquals(value, true);
		Thread.sleep(3000);
	}
	
	@Test (priority=2)
	public void validate_save_btn_with_blank_field() throws InterruptedException {
		userpage.userSaveBtn(" ", " ");
		boolean value = driver.findElement(By.id("vsUserDetails")).isDisplayed();
		Assert.assertEquals(value, true);
		Thread.sleep(3000);
		}
	
	@Ignore
	@Test(priority =3)   // Validation Remaining(user save successfully popup)
	public void validateEditBtn_withvalidData_and_Update() {
		userpage.userEditBtn("Team", "lease");
		
	}
	
	
	@Test (priority=4)
	public void validateEditBtn_withInvalidData() throws InterruptedException {
		userpage.userEditBtn("123", "567");
		boolean value = driver.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed();
		Assert.assertEquals(value, true);
		Thread.sleep(3000);
		}
	
	@Test (priority=5) 
	public void validateDropDown() throws InterruptedException{
		userpage.searchBar();
		String text = driver.findElement(By.xpath("//td[text()='Ajinkya k']")).getText();
		Assert.assertEquals(text, "Ajinkya k");
		Thread.sleep(3000);
		}
	
/*	@Ignore
	@Test(priority=6, enabled=false)
	public void validateSearchBarClrBtn() throws InterruptedException {
		userpage.searchBar();
		Thread.sleep(2000);
		driver.findElement(By.id("btnClear")).click();  // For clearing name
		
		boolean value = driver.findElement(By.xpath("//span[text()='Search User Name/Email']")).isDisplayed();
		Assert.assertEquals(value, true);
	}
*/
	@Test(priority=6)
	public void validateSearchBarClrBtn() throws InterruptedException {
		userpage.clearBtn();
		boolean value = driver.findElement(By.xpath("//span[text()='Search User Name/Email']")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test(priority=7)
	public void validateResetPwd() throws InterruptedException {
		userpage.reset();
		Thread.sleep(2000);
		
		String text = driver.switchTo().alert().getText();
//		System.out.println(text);
		driver.switchTo().alert().accept();
		Assert.assertEquals(text, "Password reset successful.");
	}
	
    @Test(priority=8)
	public void validateDeleteBtn() throws InterruptedException {
		userpage.delete();
		boolean value = driver.findElement(By.xpath("//div[text()='Compliance(s) assigned to this user, hence can not be delete']")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test(priority=9) 
	public void validateDeleteBtn_Cancel() throws InterruptedException {
		userpage.cancel();
	}
	
	@Ignore //validation Remaining
	@Test(priority = 10)
	public void validatePagination() throws InterruptedException {
		userpage.pagination();
		
		boolean value =driver.findElement(By.cssSelector("span[class='k-state-selected']")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test(priority = 11)
	public void validateBackBtn() {
		userpage.backBtn();
		boolean value = driver.findElement(By.xpath("//h1[text()='Entities']")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}

}
