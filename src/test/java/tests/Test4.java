package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import pageobjects.VisualizationScatterPlotPage;

public class Test4 extends TestBaseSetup {
	
	private WebDriver driver;

	@BeforeClass
	public void Start() {
		driver=getDriver();
	}
	
	@Test(groups = { "test4" })
	//	1) Open “Scatter Plot” chart for one of the sources and check it loads correctly.
	//	2) Select new time attribute via “Bottom Time Line” and check it is applied.
	//	3) Drang left time limit on the “Bottom Time Line” and check that limit and chart are updated.

	public void  Task4() {
		
		VisualizationScatterPlotPage visualizationScatterPlotPage = new VisualizationScatterPlotPage(driver);
		//1
		visualizationScatterPlotPage.clickFirstViewAllButton(12);
		visualizationScatterPlotPage.clickScatterPlotImage(8);
		visualizationScatterPlotPage.scatterPlotIsLoaded(11);
		//2
		visualizationScatterPlotPage.clickDateAttribute(5);
		visualizationScatterPlotPage.selectYearAttribute();
		visualizationScatterPlotPage.closeDataBar();
		visualizationScatterPlotPage.yearTimeWasApplied();
		//3
		visualizationScatterPlotPage.dragTimeElement();
		visualizationScatterPlotPage.checkingIfDataPickersAreCorrect();
		
		
		
		
		
	}

}
