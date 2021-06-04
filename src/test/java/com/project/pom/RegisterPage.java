package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base {

	By linkRegistroLocalizador = By.linkText("REGISTER");
	By LocalizadorPaginaRegistrar = By.xpath("//img[@src='images/mast_register.gif']");
	
	By UserNamaLocatizador = By.name("email");
	By PasswordLocalizador = By.name("password");
	By ConfirmPasswordLocalizador = By.cssSelector("input[name='confirmPassword']");
	
	By EnviarLocalizador = By.name("submit");
	
	By registeredMessage = By.xpath("//font");
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(linkRegistroLocalizador);
		Thread.sleep(2000);
		if(isDisplayed(LocalizadorPaginaRegistrar)) {
			type("qualityadmin1",UserNamaLocatizador);
			type("pass5",PasswordLocalizador);
			type("pass5",ConfirmPasswordLocalizador);
			click(EnviarLocalizador);
		} else {
			System.out.println("register page was not found");
		}
	}
	
	public String registeredMessage() {
		List<WebElement> font = findElements(registeredMessage);
		return getText(font.get(5));
	}

}
