package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import distributor.loginpage.DashboardPage;
import distributor.loginpage.EntitiesPage;
import distributor.loginpage.LoginPage;
import testbase.TestBase;

public class DashboardPageTest extends TestBase{
		
	DashboardPage dashboard_page;
	LoginPage loginpage;
	EntitiesPage entities_page;
	DashboardPageTest dashboard_page_test;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@Test(priority = 1)
	public void compliance_tab_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.proceedbtn_click(prop.getProperty("entities_search_txt"));
		dashboard_page = new DashboardPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dashboard_page.compliance_tab();
		Assert.assertTrue(dashboard_page.compliancetotal_count);
		dashboard_page.apply_btn.click();
		WebDriverWait selection_result_m_wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean selection_result_match = selection_result_m_wait.until(ExpectedConditions.textToBePresentInElement(dashboard_page.act_present, prop.getProperty("select_act_dropdown")));
		System.out.println(selection_result_match);
		Assert.assertTrue(selection_result_match);
	}
	
	
	@Test(priority = 2)
	public void clear_filter_button_test() throws InterruptedException {
		/*entities_page = new EntitiesPage();
		entities_page.proceedbtn_click(prop.getProperty("entities_search_txt"));*/
		dashboard_page_test = new DashboardPageTest();
		dashboard_page_test.compliance_tab_test();
		dashboard_page = new DashboardPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dashboard_page.clear_filter_button();
		Thread.sleep(3000);
		Assert.assertFalse(dashboard_page.select_branch.isSelected());
		Assert.assertFalse(dashboard_page.select_act.isSelected());
	}
	

	@Test(priority = 3)
	public void upcoming_tab_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.proceedbtn_click(prop.getProperty("entities_search_txt"));
		dashboard_page = new DashboardPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dashboard_page.upcoming_tab();
		Assert.assertTrue(dashboard_page.upcomingtotal_count);
		dashboard_page.apply_btn.click();
		WebDriverWait selection_result_match_wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean is_selection_result_match = selection_result_match_wait.until(ExpectedConditions.textToBePresentInElement(dashboard_page.compliance_present, "Feb 23"));
		Assert.assertTrue(is_selection_result_match);
	}
	
	
	@Test(priority = 4)
	public void upcomingtab_clear_filter_button_test() throws InterruptedException {
		dashboard_page_test = new DashboardPageTest();
		dashboard_page_test.upcoming_tab_test();
		dashboard_page = new DashboardPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dashboard_page.upcomingtab_clear_filter_button();
		Thread.sleep(5000);
		Assert.assertFalse(dashboard_page.select_compliancetype.isSelected());
		Assert.assertFalse(dashboard_page.select_branches.isSelected());
		Assert.assertFalse(dashboard_page.select_period.isSelected());
		Assert.assertFalse(dashboard_page.select_year.isSelected());
	}
	
	@Test
	public void export_n_branchcodemapping_button_test() throws InterruptedException {
		entities_page = new EntitiesPage();
		entities_page.proceedbtn_click(prop.getProperty("entities_search_txt"));
		dashboard_page = new DashboardPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dashboard_page.export_n_branchcodemapping_button();
		String brachcodemapping_wind_title = dashboard_page.branchcode_mapping_wnd_title.getText();
		Assert.assertEquals(brachcodemapping_wind_title, prop.getProperty("upcomingtab_brachcode_mapping_wnd_title"));
	}
	
	@AfterMethod
	public void closeResources() {
		driver.quit();
	}

	
}

	