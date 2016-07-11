package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import pageobjects.HumburgerMenuPage;

public class Test2 extends TestBaseSetup {
	

	private WebDriver driver;

	@BeforeClass
	public void Start() {
		driver=getDriver();
	}
	@Test(groups = { "test2" }) 
	//	1)In “Hamburger menu” (left upper corner) check that 2 sources are available.
	//	2) For one of the sources check that “Donut” and “Scatter Plot” charts are available.
	//	3) Select “Donut” chart and check that it opens and loads successfully
	
	public void Task2(){
		//1
		HumburgerMenuPage humburgerMenuPage = new HumburgerMenuPage(driver);
		humburgerMenuPage.clickingHumburgerMenu();
		humburgerMenuPage.clickDataSources();
		humburgerMenuPage.amountOfResources(2);
		// 2
		humburgerMenuPage.impalaAutomationClick();
		humburgerMenuPage.donutChartAvailability();
		humburgerMenuPage.scatterPlotChartAvailability();
		// 3
		humburgerMenuPage.donutSourceClicking();
		humburgerMenuPage.donutPageIsDisplayed(8);
	}
}
