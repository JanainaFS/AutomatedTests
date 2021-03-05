package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import br.janaina.core.DSL;

public class TestAlert {
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
	public void clickButtonAlert() {
		dsl.clicarBotao("alert");
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		dsl.escreve("elementosForm:nome", texto);
	}
	
	@Test
	public void clickButtonAlertConfirm() {
		dsl.clicarBotao("confirm");
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		dsl.clicarBotao("confirm");
		alert = getDriver().switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.dismiss();
	}
	
	@Test
	public void clickButtonAlertPropt() {
		dsl.clicarBotao("prompt");
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("8");
		alert.accept();
		Assert.assertEquals("Era 8?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}
}
