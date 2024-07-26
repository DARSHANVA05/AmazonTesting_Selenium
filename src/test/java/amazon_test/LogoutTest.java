package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LogoutTest {

	@Test
	public static void logout_test() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement amazon_login = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		amazon_login.click();
		Thread.sleep(1000);

		WebElement username = driver.findElement(By.xpath("//input[@id='ap_email']"));
		username.sendKeys("7892027335");

		WebElement submit = driver.findElement(By.xpath("//input[@id='continue']"));
		submit.click();

		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys("DarshanVA_0503");

		WebElement sign_in = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		sign_in.click();

		boolean Success = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		System.out.println(Success);

		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);

		WebElement sign_out = driver.findElement(By.xpath("//div[@id='nav-al-your-account']/a[.='Sign Out']"));
		sign_out.click();
		
		driver.close();
	}

}