package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{

	By NombreUsuarioLocatizador = By.name("userName");
	By ContraseñaLocalizador = By.name("password");
	By BttEnviar = By.name("submit");
	By localizadorUsuario = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn() {
		if(isDisplayed(NombreUsuarioLocatizador)) {
			type("qualityadmin1",NombreUsuarioLocatizador);
			type("pass5",ContraseñaLocalizador);
			click(BttEnviar);
		} else {
			System.out.println("registro no encontrado");
		}
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(localizadorUsuario);
	}

}
