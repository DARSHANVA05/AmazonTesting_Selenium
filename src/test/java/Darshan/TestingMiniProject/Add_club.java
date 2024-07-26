package Darshan.TestingMiniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_club {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String a="Bengaluru";
		String b="India";
		String c="B-lore";
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8081/");
		driver.manage().window().maximize();
		WebElement addClub=driver.findElement(By.xpath("//a[.=' Add team ']"));
		addClub.click();
		Thread.sleep(2000);
		
		WebElement clubname_txt=driver.findElement(By.xpath("//input[@id='clubName']"));
		clubname_txt.sendKeys(a);
		WebElement country_name = driver.findElement(By.xpath("//input[@id='country']"));
		country_name.sendKeys(b);
		WebElement stadium_name = driver.findElement(By.xpath("//input[@id='stadium']"));
		stadium_name.sendKeys(c);
		
		WebElement save_btn = driver.findElement(By.xpath("//button[.=' Save Club ']"));
		save_btn.click();
		//Thread.sleep(15000);
		//driver.quit();
		
		//Verifying added data in the list
		
		WebElement clubname = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]"));
		
		WebElement countryname = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[2]")); 

		WebElement stadiumname = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[3]")); 
				
		if(clubname.getText().equalsIgnoreCase(a)&& countryname.getText().equalsIgnoreCase(b) && stadiumname.getText().equalsIgnoreCase(c))
		{
			System.out.println("All fields are verified");
		}
		else {
			System.out.println("Fields are not verified");
		}
		driver.quit();
				
//				ddteam_Xpath = "//a[.=' Add team ']"
//				Clubname_Xpath = "//input[@id="clubName"]"
//				Country_Xpath = "//input[@id="country"]"
//				Stadium_Xpath = "//input[@id="stadium"]"
//				SaveClubBTN_Xpath = "//button[.=" Save Club "]"
		
		
		

	}

}
