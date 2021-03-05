package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.janaina.core.DSL;

public class TestAjax {
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escreve("j_idt299:name", "Janaina");
		dsl.clicarBotao("j_idt299:j_idt303");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt299:display"), "Janaina"));
		Assert.assertEquals("Janaina", dsl.obterTexto("j_idt299:display"));
	}
}
