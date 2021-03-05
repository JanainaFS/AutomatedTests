import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.janaina.core.DSL;

public class TestPrime {
	private DSL dsl;
	
	@Before
	public void inicializa() {
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void interagirRadioButton() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");

		dsl.clicarRadio(By.xpath("//*[@id='j_idt300:console:1']//../..//span"));
		Assert.assertTrue(dsl.verificarRadioSelecionado("j_idt300:console:1"));
		
		dsl.clicarRadio(By.xpath("//label[.='Option3']/..//span"));
		Assert.assertTrue(dsl.verificarRadioSelecionado("j_idt300:console:2"));
		
	}
	
	@Test
	public void interagirSelect() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt299:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt299:option_label"));
	}
	
}
