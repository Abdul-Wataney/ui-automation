package com.SWAGLABS.Testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuBar {
	
	WebDriver driver;
	Constants constant = new Constants();

	@BeforeMethod
	public void login() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", constant.chrome_path);
		driver = new ChromeDriver();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "1024x768");
		driver.get("https://www.saucedemo.com/");
		
		WebElement loginTextBox = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement passwordTextBox = driver.findElement(By.name("password"));
		
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		loginTextBox.sendKeys("standard_user");
		passwordTextBox.sendKeys("secret_sauce");
		LoginButton.click();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Wait = new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")));
		
		WebElement Menu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
		Menu.click();
		Thread.sleep(2000);		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
		

	@Test 
	public void allItemTest() {
		WebElement allItem = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[1]"));
		allItem.click();
		boolean actualResult = allItem.isDisplayed();
		Assert.assertTrue(actualResult, "the All Item is not displayed");
	}
	
	
	@Test 
	public void aboutTest() {
		WebElement about = driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]"));
		about.click();
		
		/*WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(20))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/div/a")));*/
	
		WebElement develop = driver.findElement(By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/h1"));
		boolean actualResult = develop.isDisplayed();
		Assert.assertTrue(actualResult, "the About page is not displayed");
		
	}
	
	
	@Test 
	public void resetAppStateTest() {
		
		WebElement resetAppState = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[4]"));
		resetAppState.click();
		boolean actualResult = resetAppState.isDisplayed();
		Assert.assertTrue(actualResult, "the Reset APP State is not displayed");
	}
	
	
	@Test 
	public void logOutTest() {
		
		WebElement logOut = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
		logOut.click();
		
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
		boolean expectedResult = true;
		boolean actualResult = logo.isDisplayed();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	

}
