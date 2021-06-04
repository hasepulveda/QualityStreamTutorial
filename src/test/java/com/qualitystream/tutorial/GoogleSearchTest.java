package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

	private WebDriver driver;//se crea el objeto driver tipo web driver 
	
	By VideoLocalizador = By.cssSelector("a[href=\"https://www.youtube.com/watch?v=R_hh3jAqn8M\"]");
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");// para que el objeto sea reconocible por el sistema se le debe indicar donde esta el ejecutable 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));//findElement(By.id("NombreID") By.name() By.className(), By.tagname(p,div,b) By.linkText() By.PartialLinkText(), By.cssSelector(), By.xpath(), javaScip )
		
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		
		searchbox.submit();
		// espera inplicita 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//explicit Wait
		//WebDriverWait ewait = new WebDriverWait(driver, 10);//espera un maximo de 10 ssegundos hace consultas cada 0.5 s
		//ewait.until(ExpectedConditions.titleContains("quality-stream"));// nombre del canal hasta ue cargue el titulo de la pagina //condicion de espera
		
		// fluentWait se usa para las llamadas que hutilizan ajax ya que los tiempos de cargas son variados asincronicos 
		
		
		
		//assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());

		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)//objeto fluenWait
				.withTimeout(10, TimeUnit.SECONDS)//timepo espera maimo 10s
				.pollingEvery(2,TimeUnit.SECONDS)//consulta de tiempo cada 2 segundos
				.ignoring(NoSuchElementException.class);//ignore la exepion NoSuchElementException
		
		WebElement video = fwait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(VideoLocalizador);
			}
		}
		);
	
		assertTrue(driver.findElement(VideoLocalizador).isDisplayed());
	}
	@After 
	public void tearDown() {
	//driver.quit();
	}
	}
