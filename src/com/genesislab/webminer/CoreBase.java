package com.genesislab.webminer;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoreBase 
{
	@SuppressWarnings("unused")
	private static URL chromeDriverUrl = CoreBase.class.getResource("/chromedriver.exe");
	
	public void GoogleSearch(String keyword, int scale) throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		//options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "/home/schathuranga/Softwares/GoogleChromeDriver/Linux/chromedriver"); // "E:/GenesisLab/GoogleChromeDriver/chromedriver.exe" "C:/chromedriver.exe"
		WebDriver unitDriver = new ChromeDriver(options);
		
		// Declaring and initializing the HtmlUnitWebDriver
		// HtmlUnitDriver unitDriver = new
		// HtmlUnitDriver(BrowserVersion.CHROME);
		unitDriver.manage().window().maximize();
		unitDriver.get("https://www.google.com/");
		unitDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// enter credentials
		WebElement searchTextField = unitDriver.findElement(By.id("lst-ib"));
		searchTextField.sendKeys(keyword);
		searchTextField.sendKeys(Keys.ENTER);
		Thread.sleep(100);

		unitDriver.quit();
	}
}