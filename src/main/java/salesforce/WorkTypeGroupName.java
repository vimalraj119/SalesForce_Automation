package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WorkTypeGroupName {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("August@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		WebElement clickWorkType = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickWorkType);
		WebElement clickWorkTab = driver.findElement(By.xpath(
				"//div[@class='slds-context-bar__label-action slds-p-left_none slds-p-right_x-small']//a//span//lightning-primitive-icon"));
		js.executeScript("arguments[0].click();", clickWorkTab);
		WebElement clickNewWork = driver
				.findElement(By.xpath("//one-app-nav-bar-menu-item[@class='slds-dropdown__item']//a"));
		js.executeScript("arguments[0].click();", clickNewWork);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by VimalRaj");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verWorkType = driver
				.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by VimalRaj']"))
				.getText();
		if (verWorkType.equals("Salesforce Automation by VimalRaj")) {
			System.out.println("WorkType created successfully");
		} else {
			System.out.println("WorkType was not created");
		}
	}

}
