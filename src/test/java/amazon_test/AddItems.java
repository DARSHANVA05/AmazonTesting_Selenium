package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddItems {

	@Test
	public void add_items() throws InterruptedException {
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

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		dropdown.click();
		Select s = new Select(dropdown);
		s.selectByVisibleText("Books");

		WebElement search_bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_bar.sendKeys("Arts");

		WebElement search_books = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		search_books.click();

		WebElement search = driver.findElement(By.xpath("//div[@data-index='2']//img[@data-image-index='1']"));
		search.click();

		WebElement quantity_before = driver.findElement(By.xpath("//span[@id='a-autoid-1']//span[@class='a-dropdown-prompt']"));
		String before_q = quantity_before.getText();
		System.out.println(before_q);
		
		WebElement quantity = driver.findElement(By.xpath("//span[@id='a-autoid-1-announce']"));
		quantity.click();
		
		WebElement qty = driver.findElement(By.xpath("//ul[@class='a-nostyle a-list-link']/li[2]"));
		qty.click();
	
		
		
		WebElement add_to_cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		add_to_cart.click();

		
		WebElement payement = driver.findElement(By.xpath("//input[@data-feature-id='proceed-to-checkout-action']"));
		payement.click();
		
		driver.close();

	}

}
