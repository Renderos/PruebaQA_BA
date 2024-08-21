package com.example.PruebaQASeleniumJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
class PruebaQaSeleniumJavaApplicationTests {

	private WebDriver driver;

	@BeforeEach
	void getUp(){
		driver = new ChromeDriver();
	}

	@Test
	void PruebaQA() {
		String test_password = "Password123";
		String message;

		//ingresar al sitio
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();

		//Crear cuenta
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
		driver.findElement(By.id("firstname")).sendKeys("Ronald Ernesto");
		driver.findElement(By.id("lastname")).sendKeys("Renderos Ramos");
		driver.findElement(By.id("email_address")).sendKeys("ronald.renderos@testmail.com");
		driver.findElement(By.id("password")).sendKeys(test_password);
		driver.findElement(By.id("password-confirmation")).sendKeys(test_password);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")).click();

		//Obtener mensaje e imprimir en consola
		message = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println(message);

		//Cerrar sesión
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.close();
	}

}
