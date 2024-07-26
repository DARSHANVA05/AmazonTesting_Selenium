package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Orders {

	@Test
	public void orders() throws InterruptedException {
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

		WebElement orders = driver.findElement(By.xpath("//a[@id='nav-orders']"));
		orders.click();

		WebElement success_message = driver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']//div//h1"));
		String success_msg = success_message.getText();
		System.out.println(success_msg);
		if (success_msg.equals("Your Orders")) {
			System.out.println("Succesfull in getting order list!");
		} else {
			System.out.println("Unsuccesfull in getting order list!");
		}
		
		driver.close();
	}

}
