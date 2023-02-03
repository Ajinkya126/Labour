package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.CorporatePage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class CorporatePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	CorporatePage corporatepage;
	
	@BeforeMethod
	public void init() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		corporatepage = homepage.click_on_corporate_btn();
  }
	
	@Test(priority = 1)   // Dropdown section remaining(City) and Validation Remaining
	public void validateAllField() throws InterruptedException {
	//	corporatepage.custumerDetails("Royal");
		corporatepage.custumerDetails("Royal", "Harshal", "9876543210", "harshal@gmail.com", "87654321237645", "345678909876", "Pune");
	}
	
	@Test(priority = 2)
	public void validateSavebtnWith2MandField() throws InterruptedException {
		corporatepage.clickOnSaveBtn("Royal", "Sagar");
		
	 	boolean value = driver.findElement(By.cssSelector(".alert.alert-success")).isDisplayed();
	 	Assert.assertEquals(value, true);
	}
	
	@Test(priority = 4)
	public void validateEditBtn_ValidData() throws InterruptedException {
		corporatepage.editBtn("sumit", "sumit@gmail.com");
		
		boolean value = driver.findElement(By.id("ValidationSummary1")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test(priority=5)
	public void validateEditBtn_InvalidData() throws InterruptedException {
		corporatepage.editBtn("12@123anu", "karanjohar");
		
		boolean value = driver.findElement(By.cssSelector("div[id='ValidationSummary1'] ul li")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
	@Test(priority=6)
	public void validateCustumerNameDD() throws InterruptedException {
		corporatepage.custnamedd();
		
		boolean value = driver.findElement(By.xpath("//td[normalize-space()='AVAMAHIN']")).isDisplayed();
		Assert.assertEquals(value, true);
		}
	
	@Test(priority=7)
	public void validateCustClearButton() throws InterruptedException {
		corporatepage.custClearBtn();
		
		boolean value = driver.findElement(By.xpath("//span[contains(text(),'Search Customer Name/Corporate ID')]")).isDisplayed();
		Assert.assertEquals(value, true);
	}
	
    @Test(priority=8)   
	public void validateCustDeleteButton_OK() throws InterruptedException {
		corporatepage.custDeleteBtn_OK();
		
		boolean value = driver.findElement(By.xpath("//div[contains(text(),'This will also delete all')]")).isDisplayed();
		Assert.assertEquals(value, true);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
	}
	
	@Test(priority=9)  //Validation is same for priority 8 & 9
	public void validateCustDeleteButton_Cancel() throws InterruptedException {
		corporatepage.custDeleteBtn_Cancel();
		
		boolean value = driver.findElement(By.xpath("//div[contains(text(),'This will also delete all')]")).isDisplayed();
		Assert.assertEquals(value, true);
		driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]")).click();
	}
	
	@Test(priority=10)
	public void validateViewEntityButton() {
		corporatepage.viewEntityBtn();
	}
	
	@Ignore
	@Test(priority=11) //validation Remaining
	public void validatePagination() throws InterruptedException {
		corporatepage.pagination();
		boolean value =driver.findElement(By.cssSelector("span[class='k-state-selected']")).isDisplayed(); //page1
		Assert.assertEquals(value, true);
	}
	
	@Test(priority=12)
	public void validateBackBtn() {
		corporatepage.backBtn();
	}
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
	
}