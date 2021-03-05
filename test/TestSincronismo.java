package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.janaina.core.DSL;

public class TestSincronismo {
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void utilizarEsperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		dsl.escreve("novoCampo", "Deu certo!");
	}
	
	@Test
	public void utilizarEsperaImplicita() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dsl.clicarBotao("buttonDelay");
		dsl.escreve("novoCampo", "Deu certo!");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void utilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escreve("novoCampo", "Deu certo!");
	}
}
