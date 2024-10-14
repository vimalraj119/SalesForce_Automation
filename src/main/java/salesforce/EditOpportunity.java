package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditOpportunity {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", clickOpportunity);
		WebElement searchByName = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchByName.sendKeys("Salesforce Automation by VimalRaj", Keys.ENTER);
		Thread.sleep(3000);
		WebElement clickdDropDown = driver
				.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		js.executeScript("arguments[0].click();", clickdDropDown);
		driver.findElement(By.xpath("//li[@class='uiMenuItem']/a")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='9']")).click();
		WebElement clickStage = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[3]"));
		js.executeScript("arguments[0].click();", clickStage);
		WebElement clickPerception = driver.findElement(By.xpath("//span[text()='Perception Analysis']"));
		js.executeScript("arguments[0].click();", clickPerception);
		WebElement clickDelivery = driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:down'])[9]"));
		js.executeScript("arguments[0].click();", clickDelivery);
		driver.findElement(By.xpath("//span[text()='In progress']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verPerception = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		if (verPerception.equals("Perception Analysis")) {
			System.out.println("Selected Perception Analysis");
		} else {
			System.out.println("Perception Analysis was not selected");
		}
	}

}
