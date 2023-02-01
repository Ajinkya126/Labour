package util;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import testbase.TestBase;

public class Utility extends TestBase {

	public static void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
	
	public static void mouseOverAction(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	
     // Static DropDown(by SDET)
	public static void selectOptionFromDropDown_static(WebElement ele, String value) { // WebElemet abc = driver.findelement(by.));
		                                                                		// selectOptionFromDropDown(abc, value)
		Select sel = new Select(ele);
		
		List<WebElement>alloptions=sel.getOptions();
		
		for(WebElement option:alloptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
	
	

	// Bootstrap dd (by SDET)
	 //1)First we click on dropdown element =>driver.findElement(By.).click
	 //2)Store in list => List<WebElement> statelist= driver.findElements(By.xpath("(//ul)    //in pages class
	
	public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	
	
}
