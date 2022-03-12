package com.SWAGLABS.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartShopping {

	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Constants constant = new Constants();

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
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		addToCart.click();
		
		WebElement cart = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
		cart.click();
		
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test 
	public void continueShoppingTest() {
		
		WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
		continueShopping.click();	
	}
	
	
	@Test 
	public void removeTest() {
		
		WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
		remove.click();	
	}
	
	@Test 
	public void checkOutTest() {
		
		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.click();	
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
		firstName.sendKeys("Selenium");
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Automation");
		
		WebElement postalCode = driver.findElement(By.name("postalCode"));
		postalCode.sendKeys("12345");
		
		WebElement contnue = driver.findElement(By.name("continue"));
		contnue.click();
		
		WebElement finish = driver.findElement(By.name("finish"));
		finish.click();
		
//		WebElement complete = driver.findElement(By.className("title"));
//		System.out.println(complete);
		
	}
	
	@Test 
	public void cancelTest() {
		
		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.click();
		
		WebElement cancel = driver.findElement(By.id("cancel"));
		cancel.click();
	}
}
