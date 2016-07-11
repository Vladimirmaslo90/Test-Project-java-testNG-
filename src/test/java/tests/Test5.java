package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBaseSetup;
import pageobjects.Mysql_automationPage;

public class Test5 extends TestBaseSetup{
	
	private WebDriver driver;

	@BeforeClass
	public void Start() {
		driver=getDriver();
	}
	
	@Test(groups = { "test5" })
	//	Open “Heat Map” chart for MySQL source and check it loads correctly.
	//	Click on some place of chart to invoke “Radial Menu”.
	//	Select “Zoom” option and then select some attribute to zoom into.
	//	Check that chart is updated and correct attribute is applied.
	public void Task5(){
		Mysql_automationPage mysql_automationPage = new Mysql_automationPage(driver);
		//1
		mysql_automationPage.clickingHeatMapImage(10);
		mysql_automationPage.validateLoadedCorrectly(5);
		//2
		mysql_automationPage.clickWidget(10);
		//3
		mysql_automationPage.clickZoom(6);
		mysql_automationPage.selectCityAttribute(3);
		//4
		mysql_automationPage.checkNewAttributeWasApplied();
		
	}

}
