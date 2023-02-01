package pages;

import java.util.List;

import org.checkerframework.framework.qual.FieldInvariant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.errorprone.annotations.FormatMethod;

import testbase.TestBase;
import util.Utility;

public class CorporatePage extends TestBase {
	CorporatePage corporatepage;

	@FindBy(id = "btnAdd")   
	WebElement addnewbtn; 
	
	@FindBy(id = "iframeAdd")   //Frame
	WebElement frame;          //Element Inside the frame
	
	@FindBy(name = "tbxName")
	WebElement name;
	
	@FindBy(name = "txtCorpID")
	WebElement corpID;
	
	@FindBy(id = "btnCheckCorpID")
	WebElement check;
	
	@FindBy(id = "tbxBuyerName")
	WebElement buyername;
	
	@FindBy(id = "tbxBuyerContactNo")
	WebElement buyercontno;
	
	@FindBy(id = "tbxBuyerEmail")
	WebElement buyeremail;
	
//	@FindBy(xpath = "//span[text()='Active']") //Static dd
//	WebElement statusdd;                       // "Active" Preselected
	
	@FindBy(id = "txtPAN")
	WebElement pan;
	
	@FindBy(id = "txtTAN")
	WebElement tan;
	
	@FindBy(id = "tbxAddress")
	WebElement address;
	
//	@FindBy(xpath = "//span[text()='India']") //Static dd
//	WebElement country;
	

	@FindBy(xpath = "//div[@id='ddlState_chosen']//span[contains(text(),'Select')]")
	WebElement state;
	@FindBy(xpath = "//div[@id='ddlState_chosen']//input[@type='text']")
	WebElement searchstate;
	@FindBy(xpath = "(//ul[@class='chosen-results'])[5]/child::li")
	WebElement statelist;
	
	@FindBy(xpath = "(//div[@class='chosen-container chosen-container-single'])[3]")  //Static dd city
	WebElement city;
	@FindBy(css = "div[id='ddlCity_chosen'] input[type='text']")
	WebElement searchcity;
	@FindBy(xpath = "(//ul[@class='chosen-results'])[6]/child::li")
	WebElement citylist;
	
//	@FindBy(xpath = "//span[text()='HRProduct Only']")  //Static dd
//	WebElement complianceprodtype;
	
	@FindBy(id = "btnSave")
	WebElement savebtn;
	
	
	@FindBy(xpath = "(//a[@role='button'])[1]")
	WebElement editbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Search Customer Name/Corporate ID')]")
	WebElement custdropdown;
	@FindBy(xpath = "//input[@role='listbox']")
	WebElement custddsearch;
	
	//custnamedd
	@FindBy(xpath = "//span[contains(text(),'Search Customer Name/Corporate ID')]")
	WebElement custnamdd;
	@FindBy(xpath = "//input[@role='listbox']")
	WebElement custsearch;
	@FindBy(id = "btnApply")
	WebElement custapplybtn;
	//custclearbtn
    @FindBy(id = "btnClear")
    WebElement custclearbtn;
    //custdeletebtn
    @FindBy(xpath = "//body[1]/form[1]/div[3]/section[1]/section[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[7]/a[2]")
    WebElement custdeletebtn;
 // @FindBy(xpath = "//button[normalize-space()='OK']")
 // WebElement custdelOKbtn;
    
    //View Entity Arrow(->)
    @FindBy(xpath = "//a[@class='k-button k-button-icontext k-grid-arrow-right k-grid-proceed k-state-border-down']")
    WebElement entityarrow;
		
	public void custumerDetails(String nam,String buyernam,String buyno,String mail,String panno,String tanno, String add) throws InterruptedException { //
		addnewbtn.click();
		Thread.sleep(1000);
		Utility.switchToFrame(frame);
		name.sendKeys(nam);
		corpID.click();
		check.click();
		Thread.sleep(1000);
		buyername.sendKeys(buyernam);
		buyercontno.sendKeys(buyno);
		buyeremail.sendKeys(mail);
		pan.sendKeys(panno);
		tan.sendKeys(tanno);
		address.sendKeys(add);
		
		Thread.sleep(1000);
		state.click();
//	    searchstate.sendKeys("Maharashtra");
	    
	    List<WebElement> stateoptions = driver.findElements(By.xpath("(//ul[@class='chosen-results'])[5]/child::li")); // Try Static dd and utility
	   	Utility.selectOptionFromDropDown_bs(stateoptions, "Maharashtra");
		
		Thread.sleep(1000);
	
		
		city.click();
	//	searchcity.sendKeys("Pune");
		
		 List<WebElement> cityoptions = driver.findElements(By.xpath("(//ul[@class='chosen-results'])[6]/child::li")); // Try Static dd and utility
		 Utility.selectOptionFromDropDown_bs(cityoptions, "7");  	
//			for(int i=0; i<options1.size(); i++) {
//				String webelementText1 = options1.get(i).getText();
//				System.out.println(webelementText1);
//				
//				if(webelementText1.contains("Hinjewadi Pune-411057")) {
//					options.get(i).click();
//				}
//			}
	    } 
	
	
	public void clickOnSaveBtn(String nam, String buyernam) throws InterruptedException {
		addnewbtn.click();
		Thread.sleep(1000);
		Utility.switchToFrame(frame);
		name.sendKeys(nam);
		corpID.click();
		check.click();
		Thread.sleep(1000);
		buyername.sendKeys(buyernam);
		
		savebtn.click();
	}
	
	public void editBtn(String nam, String mail) throws InterruptedException {
		editbtn.click();
		Thread.sleep(2000);
		Utility.switchToFrame(frame);
		buyername.clear();
		buyeremail.clear();
		buyername.sendKeys(nam);
		buyeremail.sendKeys(mail);
		savebtn.click();
	}
	
	public void custnamedd() throws InterruptedException {
		custnamdd.click();
		custsearch.sendKeys("Mahindra");
		List<WebElement> custdd = driver.findElements(By.xpath("//ul[@class='k-list k-reset k-virtual-list']/li"));
		Utility.selectOptionFromDropDown_bs(custdd, "AVAMAHIN (Mahindra)");
		custapplybtn.click();
	}
	
	public void custClearBtn() throws InterruptedException {
		corporatepage = new CorporatePage();
		corporatepage.custnamedd();
		custclearbtn.click();
	}
	
	public void custDeleteBtn_OK() throws InterruptedException {
		custdeletebtn.click();
		Thread.sleep(2000);
	//	custdelOKbtn.click(); // Validation prob, thats why i take element in testpage
	}
	
	public void custDeleteBtn_Cancel() throws InterruptedException {
		custdeletebtn.click();
		Thread.sleep(2000);
	}
	
	public void viewEntityBtn() {
		entityarrow.click();
	}
	    
	public CorporatePage() {
		PageFactory.initElements(driver, this);
	}
}
