package com.base.com;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
	
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String value) {
		
		if(value.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\preet\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		}
		else if(value.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\preet\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		else {
			
			System.out.println("invalid Browser name");
		}		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl(String URL) {
		driver.get(URL);

	}
	
	public static String currentURl() {
		return( driver.getCurrentUrl());
		 

	}
	
	public  static void close() {
		driver.close();

	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void navigate(String URL) {
		driver.navigate().to(URL);

	}
	public static void refresh() {
	driver.navigate().refresh();
}
	
	public static void back() {
		driver.navigate().back();

	}

	public static void forward() {
		driver.navigate().forward();
	}
	
	public static void alert(String input) {
		
		Alert a = driver.switchTo().alert();
		
		if(input.equalsIgnoreCase("accept"))
			a.accept();
		else
			a.dismiss();
	}
	
	public static void promptAlert(String input, String value) {
		
		Alert a = driver.switchTo().alert();
		if(input.equalsIgnoreCase("accept")) {
			a.sendKeys(value);
			a.accept();
		}
		else {
			a.dismiss();
		}
		
	}
	
	public static void screenShot() throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\preet\\eclipse-workspace\\MavenProject\\Screenshot\\ss.png");
        FileUtils.copyFile(source, destination);
	}
	
	public static void sendvalue(WebElement element, String input) {
		element.sendKeys(input);

	}
	public static void click(WebElement element) {
		element.click();
	}
	public static Select s;
	public static void dropdown(WebElement element,String value, String input) {
		 s= new Select(element);
		if(value.equalsIgnoreCase("text")) {
			s.selectByVisibleText(input);
		}
		else if (value.equalsIgnoreCase("value")) {
			s.selectByValue(input);
			}
		else if (value.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(input));
		}
	}
	public static boolean ismultiple() {
		return (s.isMultiple());

	}
	public static void getoptions() {
		List<WebElement> list = s.getOptions();
		for(WebElement li:list) {
			
		System.out.println(li.getText());
		}

	}
	
	public static String getfirstSelectedOption() {
		return   (s.getFirstSelectedOption().getText());

	}

	public static void allselectedOption() {

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		
		for(WebElement e:allSelectedOptions) {
			
			String text = e.getText();
		System.out.println(text);
		} 
	}
	
	
	
	public static boolean display(WebElement element) {
	return	(element.isDisplayed());
		
	}
	
	public static boolean enable(WebElement element) {
	return(	element.isEnabled());

	}
	
	public static boolean selected(WebElement element) {
		return(	element.isSelected());

		}
	public static String gettext(WebElement element) {
		return( element.getText());

	}
	
	public static String getattribute(WebElement element, String input) {
     return  ( element.getAttribute(input)) ;		

	}	
    
	public static Actions ac;
	
	public static void movetoElement(WebElement target) {
		ac.moveToElement(target).build().perform();

	}
	
	public static void contextclick(WebElement target) {
		ac.contextClick(target).build().perform();

	}
	
	public static void doubleclick(WebElement target) {
		ac.doubleClick(target).build().perform();

	}
	
	public static void dropndrop(WebElement source,WebElement destination) {
		ac.dragAndDrop(source, destination).build().perform();

	}
	
	public static void clickandhold(WebElement target) {
		ac.clickAndHold(target).build().perform();

	}
	
	public static void release(WebElement target) {
		ac.release(target).build().perform();
	}
	
	public  static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}
	
	public static void explicitwait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void fluentwait() {
		Wait wait=new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(10,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	}
	public static JavascriptExecutor js;
	private void scrollUp(String choice, WebElement element) {
		
		if(choice.equalsIgnoreCase("pixel")) {
        js.executeScript("window.scrollBy(0,800)", "");		
		}
		else if (choice.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,0)", "");
		}
		else if (choice.equalsIgnoreCase("end")) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}
		else if (choice.equalsIgnoreCase("element")) {
			js.executeScript("arguments[0].ScrollIntoView()", element);
		}
		else {
			System.out.println("Invalid scroll choice");
		}
	}
	
	public static void frames(String id, String type) {
		
				 if (type.equalsIgnoreCase("id")) {
			driver.switchTo().frame(id);
		}
		
		else if (type.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt(id));
		}
				 
		else 
			System.out.println("Invalid");
	}
	
	public static void frame(WebElement element) {
		driver.switchTo().frame(element);

	}
	
	public static void defaultcontent() {
		driver.switchTo().defaultContent();

	}
	
	public static void parentwindow() {
		driver.switchTo().parentFrame();

	}
	
	public static void getwindowHandle() {
		String windowHandle = driver.getWindowHandle();
	System.out.println(driver.switchTo().window(windowHandle).getTitle());

	}
	
	public static void gethandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String titles:windowHandles ) {
			
			System.out.println(driver.switchTo().window(titles).getTitle());
			}
	}
	
	public static void desiredPage(String pagename) {
		
		Set<String> windowHandles = driver.getWindowHandles();
for(String titles1:windowHandles) {
			
			if(driver.switchTo().window(titles1).getTitle().equals(pagename)){
				
				break;
				
			}
			else
				driver.close();}
	}
	
	public static void getTitle(WebElement element) {
		element.getText();

	}
	
	public static Robot rc;
       public static void robot() {
		
    	   rc.keyPress(KeyEvent.VK_DOWN);
   		rc.keyRelease(KeyEvent.VK_DOWN);

   		rc.keyPress(KeyEvent.VK_ENTER);
   		rc.keyRelease(KeyEvent.VK_ENTER);

	}	
	
	
	
	
	
	
	
	
	
}
	


