package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import distributor.loginpage.CorporateEntityPage;
import distributor.loginpage.LoginPage;
import testbase.TestBase;

public class CorporateEntityPageTest extends TestBase {

	CorporateEntityPage cp_entity_page;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Ignore
	@Test(priority = 1)
	public void corporate_nsearch_test() throws InterruptedException{
		cp_entity_page = new CorporateEntityPage();
		cp_entity_page.corporate_nsearch();
	}
	
	@Ignore
	@Test(priority = 2)
	public void entity_delete_test() throws InterruptedException {
		cp_entity_page = new CorporateEntityPage();
		cp_entity_page.corporate_nsearch();
		cp_entity_page.entity_delete();
	}
	
	@Test(priority = 3)
	public void back_btn_click_test() {
		cp_entity_page = new CorporateEntityPage();
		cp_entity_page.back_btn_click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String entities_page_title = driver.getTitle();
		System.out.println(entities_page_title);
		Assert.assertEquals(entities_page_title, prop.getProperty("entity_page_title"));
	}
	
	@AfterMethod
	public void closewindow(){
		driver.close();
	}
}
