import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPrime {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void interagirRadioButton() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");

		dsl.clicarRadio(By.xpath("//*[@id='j_idt300:console:1']//../..//span"));
		Assert.assertTrue(dsl.verificarRadioSelecionado("j_idt300:console:1"));
		
		dsl.clicarRadio(By.xpath("//label[.='Option3']/..//span"));
		Assert.assertTrue(dsl.verificarRadioSelecionado("j_idt300:console:2"));
		
	}
	
	@Test
	public void interagirSelect() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt299:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt299:option_label"));
	}
	
}
