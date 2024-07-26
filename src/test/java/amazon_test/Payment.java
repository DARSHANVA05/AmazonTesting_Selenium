package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Payment {

	@Test
	public void payment() throws InterruptedException {

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
		
		float calculated_amt = 0;
		for (int k = 1; k <= 3; k++) {
			WebElement select_atc = driver
					.findElement(By.xpath("//div[@data-name='Active Items']/div[@data-item-index='" + k
							+ "']//div[@class='sc-item-content-group']//div[@class='a-section a-spacing-mini']/span"));
			Thread.sleep(3000);
			cost[k] = Float.parseFloat(select_atc.getText().trim().replace(",", "").replace("INR", "").trim());
			System.out.println("Cost of product "+k+" is: "+cost[k]);
			calculated_amt = calculated_amt + cost[k];
			Thread.sleep(1500);
		}
		
		WebElement total_amt = driver.findElement(By.xpath("//div[@class='a-section sc-buy-box-inner-box']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		float toatal_amount = Float.parseFloat(total_amt.getText().trim().replace(",", "").replace("INR", "").trim());
		System.out.println("Calculated amount: "+calculated_amt);
		System.out.println("Total amount: "+toatal_amount);
		
		driver.close();
	}

}
