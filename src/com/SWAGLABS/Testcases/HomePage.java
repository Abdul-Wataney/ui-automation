package com.SWAGLABS.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AWATANY\\Downloads\\Chrome\\chromedriver.exe");
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
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

	@Test 
	public void allItemFunctionTest() throws InterruptedException {
		
		WebElement Item = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		Item.click();
		
		WebElement Menu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
		Menu.click();
		
		Thread.sleep(1000);
		
		WebElement AllItem = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[1]"));
		AllItem.click();

	}

	@Test 
	public void facebookIconTest() throws InterruptedException {
		
		WebElement facebook = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", facebook);
		Thread.sleep(1000);
		facebook.click();
		Thread.sleep(6000);
		
	}
	
	@Test 
	public void twitterIconTest() throws InterruptedException {
		
		WebElement twitter = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", twitter);
		Thread.sleep(1000);
		twitter.click();
		Thread.sleep(5000);
		
	}
	
	
	@Test 
	public void linkedInIconTest() throws InterruptedException {
		
		WebElement LinkedIn = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", LinkedIn);
		Thread.sleep(1000);
		LinkedIn.click();
		Thread.sleep(3000);
		
	}
	
	
	@Test 
	public void filterationTest() throws InterruptedException {
		
		WebElement filter = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
		
		Select optionValue = new Select(filter);
		
		optionValue.selectByValue("lohi");
		
		Thread.sleep(1000);
		WebElement filter2 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
		optionValue.selectByIndex(2);
		
		Thread.sleep(1000);
		//WebElement filter3 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
		optionValue.selectByIndex(1);
		
		Thread.sleep(1000);
		//WebElement filter4 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
		optionValue.selectByIndex(0);
		
	}


}

