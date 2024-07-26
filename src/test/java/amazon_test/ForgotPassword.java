package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ForgotPassword {
	
	@Test
	public void forgot_password() throws InterruptedException {
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
		password.sendKeys("DarshanVA_05");

		WebElement sign_in = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		sign_in.click();
		
		
		
		WebElement forgot_pass = driver.findElement(By.xpath("//a[@id='auth-fpp-link-bottom']"));
		forgot_pass.click();
		
		WebElement failure_message = driver.findElement(By.xpath("//form[@name='forgotPassword']//h1"));
		String msg = failure_message.getText();		
		System.out.println(msg);
		
		
		Assert.assertEquals("Password assistance", msg);
		driver.close();
	}

}
