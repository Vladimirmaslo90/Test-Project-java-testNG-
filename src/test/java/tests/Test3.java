package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import pageobjects.VisualizationBarsPage;

public class Test3 extends TestBaseSetup{
	private WebDriver driver;

	@BeforeClass
	public void Start() {
		driver=getDriver();
	}
	
	@Test(groups = { "test3" })
	//	1)Open “Bars” chart for one of the sources and check it is loaded.
	//	2) Set new “Group” attribute.
	//	3) Via “Left Panel” switch to “Table” chart (in “Chart Style”).
	//	4) Check that new chart is loaded and selected before group attribute is inherited and shown
	
	public void Task3(){
		//1
		VisualizationBarsPage visualizationPage = new VisualizationBarsPage(driver);
		visualizationPage.clickFirstAvailableBar(3);
		visualizationPage.barWasLoaded(13);
		//2
		visualizationPage.clickGroupButton(3);
		visualizationPage.clickCityAttribute();
		//3
		visualizationPage.clickChartStyle();
		visualizationPage.clickTableChartStyle();
		visualizationPage.clickTableChartElement();
		//4
		visualizationPage.clickConfigure(2);
		visualizationPage.checkIfCityAttributeIsSelected();
				
	}
	

}
