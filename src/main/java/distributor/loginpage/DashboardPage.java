package distributor.loginpage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class DashboardPage extends TestBase{

	//WebElements
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_compliancecountDivBox']/div/div/div[2]/div[1]")
	WebElement compliance_tab;
	
	@FindBy(xpath = "//*[@id='divCompliancesShow']/iframe")
	WebElement iframee;
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/div[1]/div/span[1]")
	public    
	WebElement select_branch;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/span[1]")
	WebElement expand_btn;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]")
	WebElement dropdown_options;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_divCompliancesCount']")
	WebElement compliance_tab_count;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[3]/span[2]")
	WebElement compliance_total_count;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/span[1]/span[1]/span[1]")
	public
	WebElement select_act;
	
	@FindBy(id = "btnApplyfilter")
	public
	WebElement apply_btn;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
	public
	WebElement act_present;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_upcomingCountDivBox']/div/div/div[2]/div[1]")
	WebElement upcoming_tab;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_divUpcomingCount']")
	WebElement upcoming_tab_count;
	
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[1]/div[3]/span[2]")
	WebElement upcoming_total_count;
	
	@FindBy(xpath = "//*[@id='divMyCompliances']/iframe")
	WebElement upcomingtab_iframe;
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/span[1]/span/span[1]")
	public
	WebElement select_compliancetype;
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/div[1]/div/span[1]")
	public
	WebElement select_branches;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/span[1]")
	public
	WebElement upcomingtab_branch_expandbtn;
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/div[2]/div/span[1]")
	public
	WebElement select_period;
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/span[2]/span/span[1]")
	public
	WebElement select_year;
	
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]")
	public
	WebElement compliance_present;
	
	/*@FindBy(id = "btnExcel")
	WebElement export_button;*/
	
	@FindBy(id = "btnBranchCodeMapping")
	WebElement branchcode_mapping_button;
	
	@FindBy(xpath = "//*[@id='divBranchCodeDetails_wnd_title']")
	public
	WebElement branchcode_mapping_wnd_title;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div/a[2]")
	WebElement branchcodemap_wnd_close;
	
	public boolean compliancetotal_count;
	public boolean upcomingtotal_count;
	
	//Actions
	public void compliance_tab() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String compliancetab_count = compliance_tab_count.getText();
		System.out.println(compliancetab_count);
		compliance_tab.click();
		driver.switchTo().frame(iframee);
		select_branch.click();
		expand_btn.click();
		List<WebElement> selectbranch =driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement select : selectbranch) {
			if(select.getText().equalsIgnoreCase("Maharashtra")) {
				Thread.sleep(3000);
				select.click();
			}
		}
		Thread.sleep(5000);
		compliancetotal_count = compliance_total_count.getText().contains(compliancetab_count);
		System.out.println(compliancetotal_count);
		select_act.click();
		List<WebElement> selectact = driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement actselect : selectact) {
			if(actselect.getText().equalsIgnoreCase(prop.getProperty("select_act_dropdown"))) {
				Thread.sleep(2000);
				actselect.click();
			}
		}
		
		
	}
	
	public void clear_filter_button() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By clear_btn = By.id("btnClearFilter");
		wait.until(ExpectedConditions.presenceOfElementLocated(clear_btn));
		WebElement clearButton = driver.findElement(clear_btn);	
		JavascriptExecutor jse1=(JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click();", clearButton);
	}
	
	public void upcoming_tab() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String upcomingtab_count = upcoming_tab_count.getText();
		System.out.println(upcomingtab_count);
		upcoming_tab.click();
		driver.switchTo().frame(upcomingtab_iframe);
		select_compliancetype.click();
		List<WebElement> selectcompliance =driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement select1 : selectcompliance) {
			if(select1.getText().equalsIgnoreCase("Register")) {
				select1.click();
			}
		}
		select_branches.click();
		Thread.sleep(5000);
		upcomingtab_branch_expandbtn.click();
		//WebDriverWait expandbtn_wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		//expandbtn_wait.until(ExpectedConditions.elementToBeClickable(upcomingtab_branch_expandbtn));
		List<WebElement> selectbranches =driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement select2 : selectbranches) {
			if(select2.getText().equalsIgnoreCase("Maharashtra")) {
				Thread.sleep(3000);
				select2.click();
			}
		}
		select_period.click();
		List<WebElement> selectperiod =driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement select3 : selectperiod) {
			if(select3.getText().equalsIgnoreCase("February")) {
				select3.click();
			}
		}
		select_year.click();
		List<WebElement> selectyear =driver.findElements(By.xpath("//li[@class='k-item']"));
		for(WebElement select4 : selectyear) {
			if(select4.getText().equalsIgnoreCase("2023")) {
				select4.click();
			}
		}
		Thread.sleep(5000);
		upcomingtotal_count = upcoming_total_count.getText().contains(upcomingtab_count);
		System.out.println(upcomingtotal_count);
		
	}
	
	public void upcomingtab_clear_filter_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("btnClearFilter")).click();
	}
	
	public void export_n_branchcodemapping_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		upcoming_tab.click();
		driver.switchTo().frame(upcomingtab_iframe);
		/*boolean is_file_exist = isFileDownloaded_exist("C:\\Users\\Madhu Kumbhar\\Downloads", "Acts & Compliances.xlsx");
		System.out.println(is_file_exist);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		By export_button = By.xpath("//*[@id='btnExcel']");
		wait.until(ExpectedConditions.presenceOfElementLocated(export_button));
		WebElement exportButton = driver.findElement(export_button);	
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", exportButton);
		jse2.executeScript("arguments[0].click();", exportButton);
		//export_button.click();
		isFileDownloaded("C:\\Users\\Madhu Kumbhar\\Downloads", "Acts & Compliances.xlsx");*/
		branchcode_mapping_button.click();
	}
	
	public boolean isFileDownloaded_exist(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
	
	public void isFileDownloaded(String downloadPath, String fileName) throws InterruptedException {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < 3; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		    	  System.out.println("File downloaded successfully");
		          break;
		      }
		      else {
		    	  Thread.sleep(5000);
		      }
		    }
		      
		  }
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
}
