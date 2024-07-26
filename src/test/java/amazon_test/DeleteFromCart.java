package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DeleteFromCart {

	@Test
	public void delete_from_cart() throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement amazon_login = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		amazon_login.click();
		Thread.sleep(1000);

		WebElement username = driver.findElement(By.xpath("//input[@id='ap_email']"));
		username.sendKeys("9964640485");

		WebElement submit = driver.findElement(By.xpath("//input[@id='continue']"));
		submit.click();

		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys("Vinay76765@");

		WebElement sign_in = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		sign_in.click();

		WebElement search_bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_bar.sendKeys("laptops");

		WebElement search = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		search.click();

		WebElement add_to_cart = driver.findElement(By.xpath("//button[@id='a-autoid-1-announce']"));
		add_to_cart.click();

		Thread.sleep(4000);

		WebElement success_msg = driver.findElement(By.xpath("//div[@class='a-changeover-inner']/strong"));
		String text = success_msg.getText();
		System.out.println(text);
		Assert.assertEquals("Item Added", text);

		Thread.sleep(4000);

		WebElement cart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
		cart.click();

		WebElement delete_item = driver.findElement(By.xpath("//input[@value='Delete']"));
		delete_item.click();
		Thread.sleep(3000);
		
		WebElement msg = driver.findElement(By.xpath("//div[@class='a-row sc-cart-header']//h1"));
		String delete_msg = msg.getText();
		System.out.println(delete_msg);
		
		driver.close();
	}

}