package week6_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//p[@data-cy='AppDownloadSubText']")).click();

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(3000);
		}

		By wResult = By.xpath("//span[text()='FILTERS']");
		String w1Result = driver.findElement(wResult).getText();
		System.out.println(w1Result + ".......Expected Title ");

		driver.close();

		driver.switchTo().window(winHandleBefore);

		driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/hotels/']")).click();
		
		driver.quit();

	}
}