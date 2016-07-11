package tests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import base.TestBaseSetup;
import pageobjects.HomePage;


public class Test1 extends TestBaseSetup {
	
	private WebDriver driver;

	@BeforeClass
	public void Start() {
		driver=getDriver();
		
	}
	
	@Test(groups = { "test1" })
	//Login with given credentials and check that “Home” page is opened and two sources are available for the user.
		public void Task1(){
		HomePage homePage = new HomePage(driver);
		homePage.homePageIsDisplayed();
		homePage.availableResources(2);
	}
}
	
 
