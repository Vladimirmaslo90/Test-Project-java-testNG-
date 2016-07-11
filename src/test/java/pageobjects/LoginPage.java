package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage (WebDriver driver){
		this.driver = driver;
	}
	
	public void enterLogin(String login) {
		WebElement loginInput = driver.findElement(By.cssSelector("input#username"));
		if(loginInput.isDisplayed())
			loginInput.sendKeys(login);
	}
	
	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(By.cssSelector("input#password"));
		if(passwordInput.isDisplayed())
			passwordInput.sendKeys(password);
	}
	
	public void clickOnLogin(){
		WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
		if(loginButton.isDisplayed())
			loginButton.click();;
	}
	
	
}
