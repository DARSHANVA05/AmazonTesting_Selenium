package Darshan.TestingMiniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AddPlayer {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8081/");
		driver.manage().window().maximize();
		WebElement addClub=driver.findElement(By.xpath("//a[.=' Add Player ']"));
		addClub.click();
		Thread.sleep(2000);
		
		String fn = "vinay";
		String ln = "p";
		String nationality = "indian";
		String teamName = "RCB";
		String jerseyNo = "10";
		String position = "cm";
		String clubId ="1";
		
		WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.sendKeys(fn);
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys(ln);
		WebElement nationalityi = driver.findElement(By.xpath("//input[@id='nationality']"));
		nationalityi.sendKeys(nationality);
		WebElement team_Name=driver.findElement(By.xpath("//input[@id='teamName']"));
		team_Name.sendKeys(teamName);
		WebElement country_name = driver.findElement(By.xpath("//input[@id='jerseyNo']"));
		country_name.sendKeys(jerseyNo);
		WebElement stadium_name = driver.findElement(By.xpath("//input[@id='position']"));
		stadium_name.sendKeys(position);
		WebElement clubid = driver.findElement(By.xpath("//input[@id='clubId']"));
		clubid.sendKeys(clubId);
		
		WebElement save_btn = driver.findElement(By.xpath("//button[.=' Save Player']"));
		save_btn.click();
		
	}

}
