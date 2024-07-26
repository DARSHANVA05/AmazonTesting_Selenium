package amazon_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Search {
	
	@Test
	public  void search() throws InterruptedException {
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
		s.selectByVisibleText("Computers");

		WebElement search_bar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search_bar.sendKeys("laptops");

		WebElement search = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		search.click();

		Thread.sleep(2000);

		driver.close();

	}

}
