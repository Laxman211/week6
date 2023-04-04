package week6_test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUps {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		// From City
		driver.findElement(By.xpath("//input[@id = 'fromCity']//parent::label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys("Mumbai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();

		// To City
		driver.findElement(By.xpath("//input[@id='toCity']//parent::label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'To')]")).sendKeys("chennai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Chennai International Airport']")).click();

		// from and to date selection
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[2]/div"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Return']")).click();
		DateFormat toDate = new SimpleDateFormat("dd");
		Date Tdate = new Date();
		String date2 = toDate.format(Tdate);
		System.out.println(date2);
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[3]"))
				.click();

		// Travelers and CLass Selection
		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApply pushRight']")).click();
		driver.findElement(By.xpath("//a[@class ='primaryBtn font24 latoBold widgetSearchBtn ']//self::a")).click();
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement resultPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Mumbai → Chennai']")));
		resultPage.getText();

		// Result Page Validation
		By sResult = By.xpath("//b[text()='Mumbai → Chennai']");
		String tResult = driver.findElement(sResult).getText();
		System.out.println(tResult + " ......Expected Title ");
		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();

		driver.quit();

	}

}
