package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CreateAccount {

	@Test
	public void create_account() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement amazon_login = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		amazon_login.click();
		Thread.sleep(1000);
	
		WebElement create_account = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
		create_account.click();
		
		WebElement msg = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
		Assert.assertEquals("Create account", msg.getText());
		
		driver.close();
	}
	
}
