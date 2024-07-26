package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amount_validationD {

	@Test
	public void amount_validation_d() throws InterruptedException {

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

		float calculated_amt1 = 0;
		for (int k = 1; k <= 3; k++) {
			WebElement select_atc = driver
					.findElement(By.xpath("//div[@data-name='Active Items']/div[@data-item-index='" + k
							+ "']//div[@class='sc-item-content-group']//div[@class='a-section a-spacing-mini']/span"));
			Thread.sleep(3000);
			cost[k] = Float.parseFloat(select_atc.getText().trim().replace(",", "").replace("INR", "").trim());
			System.out.println("Cost of product " + k + " is: " + cost[k]);
			calculated_amt1 = calculated_amt1 + cost[k];
			Thread.sleep(1500);
		}

		WebElement total_amt = driver.findElement(By.xpath(
				"//div[@class='a-section sc-buy-box-inner-box']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		float total_amount = Float.parseFloat(total_amt.getText().trim().replace(",", "").replace("INR", "").trim());
		System.out.println("Calculated amount: " + calculated_amt1);
		System.out.println("Total amount: " + total_amount);

		WebElement product1_amt = driver
				.findElement(By.xpath("//div[@data-name='Active Items']/div[@data-item-index='1']//div[@class='sc-item-content-group']//div[@class='a-section a-spacing-mini']/span"));
		float product1_val = Float.parseFloat(product1_amt.getText().trim().replace(",", "").replace("INR", "").trim());
		
		
		WebElement delete_ele = driver.findElement(By.xpath("//div[@data-item-index='1']//div[@class='a-row sc-action-links']/span[@data-feature-id='delete']"));
		delete_ele.click();
		Thread.sleep(5000);
		
		float new_amt = calculated_amt1 - product1_val;
		Thread.sleep(4000);
		WebElement total_amt_after = driver.findElement(By.xpath(
				"//div[@class='a-section sc-buy-box-inner-box']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		float total_amount_after = Float.parseFloat(total_amt_after.getText().trim().replace(",", "").replace("INR", "").trim());
		System.out.println("Calculated amount after deletion: " + new_amt);
		System.out.println("New Total amount: " + total_amount_after);
		
		driver.close();
		

	}

}
