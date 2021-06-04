package com.qualitystream.tutorial;
//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	By linkRegistroLocalizador = By.linkText("REGISTER");
	By LocalizadorPaginaRegistrar = By.xpath("//img[@src='images/mast_register.gif']");
	By UserNamaLocatizador = By.name("email");
	By PasswordLocalizador = By.name("password");
	By ConfirmPasswordLocalizador = By.cssSelector("input[name='confirmPassword']");
	By EnviarLocalizador = By.name("submit");
	By NombreUsuarioLocatizador = By.name("userName");
	By ContraseñaLocalizador = By.name("password");
	By BttEnviar = By.name("submit");
	By localizadorUsuario = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");// para que el objeto sea
																								// reconocible por el
																								// sistema se le debe
																								// indicar donde esta el
																								// ejecutable
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();// cierra el navegador
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(linkRegistroLocalizador).click();
		Thread.sleep(2000);
		if (driver.findElement(linkRegistroLocalizador).isDisplayed()) {
			driver.findElement(UserNamaLocatizador).sendKeys("admin1");
			driver.findElement(PasswordLocalizador).sendKeys("admin11");
			driver.findElement(ConfirmPasswordLocalizador).sendKeys("admin11");
			driver.findElement(EnviarLocalizador).click();

		} else {
			System.out.println("registro no encontrado");
		}

		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		

		assertEquals("Note: Your user name is admin1.", fonts.get(5).getText());

	}

	@Test
	public void signIn() throws InterruptedException {

		if (driver.findElement(NombreUsuarioLocatizador).isDisplayed()) {
			driver.findElement(NombreUsuarioLocatizador).sendKeys("admin1");
			driver.findElement(ContraseñaLocalizador).sendKeys("admin11");
			driver.findElement(BttEnviar).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(localizadorUsuario).isDisplayed());
		} else {
			System.out.println("registro no encontrado");
		}
	}

}
