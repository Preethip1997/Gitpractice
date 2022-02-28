package com.project;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\preet\\eclipse-workspace\\Test\\driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
		
		Actions ac=new Actions(driver);
		
		ac.moveToElement(women).build().perform();
		
		ac.contextClick(women).build().perform();
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement dress = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		
		ac.contextClick(dress).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Set<String> set = driver.getWindowHandles();
		
						
		for(String se:set) {
			
			
		if(	driver.switchTo().window(se).getTitle().equals("Women - My Store")) {
			
			break;
		}
			
		else {
			
			driver.close();
		}		}
		
				
		WebElement quickView = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		
		Thread.sleep(3000);	
		
		quickView.click();	
		
		Thread.sleep(3000);
		
        WebElement frame = driver.findElement(By.xpath("//iframe"));
		
		driver.switchTo().frame(frame);
		
		WebElement addTo = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		
		addTo.click();
		
		
		
			driver.switchTo().defaultContent();
			Thread.sleep(3000);

      WebElement proceed = driver.findElement(By.xpath("(//span)[30]"));
		
		proceed.click();
		
		Thread.sleep(3000);
		
		WebElement checkout = driver.findElement(By.xpath("(//span)[48]"));
		checkout.click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		WebElement email = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys("preethi778877@gmail.com");
		
		driver.findElement(By.xpath("(//span)[37]")).click();
		
		Thread.sleep(3000);
		
//		driver.findElement(By.name("customer_firstname")).sendKeys("Preethi");
//		driver.findElement(By.id("customer_lastname")).sendKeys("Purushothaman");
//		driver.findElement(By.cssSelector("input#passwd")).sendKeys("Preethi1997");
//		
//		driver.findElement(By.cssSelector("input#address1")).sendKeys("21 Meenakshi Nagar,Mannargudi");
//		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Mannargudi");
//		
//		WebElement state = driver.findElement(By.xpath("//select[@name='id_state']"));
//		
//		Select s=new Select(state);
//		
//		s.selectByValue("14");
//		
//		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("00000");
//		
//		driver.findElement(By.name("phone_mobile")).sendKeys("7358699140");
//		
//		Thread.sleep(3000);
//		
//		WebElement element = driver.findElement(By.id("alias"));
//		element.clear();
//		element.sendKeys("mannai");
//		driver.findElement(By.id("submitAccount")).click();
		
		driver.findElement(By.id("email")).sendKeys("preethi97.p@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Preethi1997");
		
		driver.findElement(By.xpath("(//span)[39]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//span)[44]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("cgv")).click();
		
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("(//span)[38]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("bankwire")).click();
		
		 driver.findElement(By.xpath("(//span)[36]")).click();
		 
		 
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 
		 File as = ts.getScreenshotAs(OutputType.FILE);
		 
		 File des=new File("C:\\Users\\preet\\eclipse-workspace\\MavenProject\\Screenshot\\new.png");
		 
		 FileUtils.copyFile(as, des);
		
	}

	
	
}
