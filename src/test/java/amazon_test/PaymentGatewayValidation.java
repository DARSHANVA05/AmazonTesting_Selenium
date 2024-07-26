package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PaymentGatewayValidation {

	@Test
	public void payment_gateway_validation() throws InterruptedException {
		
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

		WebElement search_bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_bar.sendKeys("bose soundbar");

		WebElement search = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		search.click();

		float cost[] = new float[4];

		for (int i = 1; i <= 3; i++) {

			WebElement add_to_cart = driver.findElement(
					By.xpath("//div[@class='a-section puis-atcb-add-container aok-inline-block']//span[@id='a-autoid-"
							+ i + "']"));
			add_to_cart.click();
			Thread.sleep(5000);

		}
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
		cart.click();
		
		Thread.sleep(2000);
		WebElement payment = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
		payment.click();
		
		WebElement validaion = driver.findElement(By.xpath("//div[@class='a-column a-span8']/h1"));
		System.out.println(validaion.getText());		
	
		driver.close();
	}
	
}
