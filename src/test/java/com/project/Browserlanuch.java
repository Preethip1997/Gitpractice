package com.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.com.Methods;

public class Browserlanuch extends Methods {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = browserLaunch("Chrome");

		launchUrl("https://www.facebook.com/");

		System.out.println(currentURl());

		WebElement element = driver.findElement(By.name("email"));

		sendvalue(element, "Preethi1997@gmail.com");

		WebElement element1 = driver.findElement(By.name("pass"));

		sendvalue(element1, "19971218");
		WebElement element2 = driver.findElement(By.name("login"));

		click(element2);
	}

}
