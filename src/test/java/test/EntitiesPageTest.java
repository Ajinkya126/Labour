package test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import distributor.loginpage.EntitiesPage;
import distributor.loginpage.LoginPage;
import testbase.TestBase;

public class EntitiesPageTest extends TestBase{
	
	EntitiesPage entities_page;
	LoginPage loginpage;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void entities_search_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.entities_search(prop.getProperty("entities_search_txt"));
		Thread.sleep(5000);
		String searched_text = prop.getProperty("entities_search_txt");
		boolean stxtpresent = driver.getPageSource().contains(searched_text);
		System.out.println(stxtpresent);
		Assert.assertTrue(stxtpresent, searched_text);
	}
	
	public void entitylocation_exceldowld_test() {
		entities_page.entitylocation_exceldowld();
	}
	
	public void entity_exceldowld_test() {
		entities_page.entity_exceldowld();
	}
	
	@Test(priority = 2)
	public void logo_test() throws InterruptedException{
		entities_page = new EntitiesPage();
		entities_page.logo();
	}
	
	@Test(priority = 3)
	public void logout_action_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.logout_action();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String lpage_title = driver.getTitle();
		System.out.println(lpage_title);
		Assert.assertEquals(lpage_title, prop.getProperty("login_page_title"));
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void proceedbtn_click_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.proceedbtn_click(prop.getProperty("entities_search_txt"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String dashboard_title = driver.getTitle();
		System.out.println(dashboard_title);
		Assert.assertEquals(dashboard_title, prop.getProperty("dashboard_page_title"));
	}
	
	@AfterMethod
	public void closeResources() {
		
    //  public void closewindow() throws InterruptedException {
	//	Thread.sleep(2000);
		driver.quit();
	}

}
