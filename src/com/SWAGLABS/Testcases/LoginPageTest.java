package com.SWAGLABS.Testcases;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	WebDriver driver;
	Constants constant = new Constants();
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", constant.chrome_path);
		driver = new ChromeDriver();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "1024x768");
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test (priority=1)
	public void titleTest() {
		
		String expectedResult = "Swag Labs";
		String actualResult = driver.getTitle();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test (priority=2)
	public void urlCheck() {
		
		String expectedResult ="https://www.saucedemo.com/";
		String actualResult = driver.getCurrentUrl();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test (priority=3)
	public void logoTest() {
	
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
		boolean expectedResult = true;
		boolean actualResult = logo.isDisplayed();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	
	@Test (priority=4 , dataProvider="myData")
	public void loginTest(String username , String password ) {
		
		WebElement loginTextBox = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		loginTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		LoginButton.click();
		
	}
	
	
	@DataProvider
	public Object[][] myData() {
		
		Object[][] data = new Object[4][2];
		data[0][0] = "standard_user"; //correct user-name
		data[0][1] = "secret_sauce";  // correct password
		data[1][0] = "standard_user"; // correct user-name
		data[1][1] = "test123";		  // Wrong Password
		data[2][0] = "user123";		  // wrong user-name
		data[2][1] = "secret_sauce";  // correct password
		data[3][0] = "user123"; 	  // wrong user-name
		data[3][1] = "test123";	      // wrong password
		
		return data;
		
		
		
	}
}
