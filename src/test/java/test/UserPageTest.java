package test;

import org.testng.annotations.Test;

import distributor.loginpage.UserPage;
import testbase.TestBase;

public class UserPageTest extends TestBase{
	
	UserPage up;
	
	@Test
	public void user_btn_click() {
		up = new UserPage();
		up.userbtn_action();
	}

}
