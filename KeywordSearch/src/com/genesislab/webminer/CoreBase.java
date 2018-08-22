package com.genesislab.webminer;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CoreBase {
	public static final String EXCEL_FILE_LOCATION = "C:\\Users\\ASUS\\Desktop\\MyFormattedExcel.csv";
	WritableWorkbook myFirstWbook = null;

	@SuppressWarnings("unused")
	private static URL chromeDriverUrl = CoreBase.class.getResource("/chromedriver.exe");

	public void GoogleSearch(String keyword, int scale) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		// options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe"); // "E:/GenesisLab/GoogleChromeDriver/chromedriver.exe"
																				// "C:/chromedriver.exe"
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

		// Get details from blogs
		for (int i = 1; i <= scale; i++) {
			String sitename=unitDriver.findElement(By.xpath("(//cite[contains(text(),'https://')]/../../../../h3/a)[" + i + "] | (//cite[contains(text(),'www')]/../../../../h3/a)[" + i + "]")).getText();
			
			unitDriver.findElement(By.xpath("(//cite[contains(text(),'https://')]/../../../../h3/a)[" + i + "] | (//cite[contains(text(),'www')]/../../../../h3/a)[" + i + "]"))
					.click();

			Boolean textVisible = unitDriver
					.findElement(By
							.xpath("//*[contains(text(),'About') or contains(text(),'Contact') or contains(text(),'Contact Us') or contains(text(),'About Us')]"))
					.isDisplayed();
			unitDriver
					.findElement(By
							.xpath("//*[contains(text(),'About') or contains(text(),'Contact') or contains(text(),'Contact Us') or contains(text(),'About Us')]"))
					.click();
			if (textVisible == true) {

				String emailaddress = unitDriver
						.findElement(By.xpath(" //a[contains(text(),'@')] | //p[contains(text(),'@')]")).getText();
				
				WriteExcel(emailaddress,sitename);

			} else {
				System.out.println("Information is not public");
			}

		}
		// TearDown driver
		unitDriver.quit();
	}

	public void WriteExcel(String email,String sitename) {

		try {
			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
		
			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			// add something into the Excel sheet
			Label label = new Label(0, 0, "Test Count");
			excelSheet.addCell(label);
			
			Label label1 = new Label(0, 1, sitename);
			excelSheet.addCell(label1);
			
			

			label = new Label(1, 0, "Result");
			excelSheet.addCell(label);

			label = new Label(1, 1, email);
			excelSheet.addCell(label);


			myFirstWbook.write();
			myFirstWbook.close();
			System.out.println("-------Done----------");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}