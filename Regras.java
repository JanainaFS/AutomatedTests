import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Regras {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void validacaoNome() {
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoSobrenome() {
		dsl.escreve("elementosForm:nome", "Janaina");
		
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoSexo() {
		dsl.escreve("elementosForm:nome", "Janaina");
		dsl.escreve("elementosForm:sobrenome", "Feitosa");
		
		dsl.clicarBotao("elementosForm:cadastrar");

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoComida() {
		dsl.escreve("elementosForm:nome", "Janaina");
		dsl.escreve("elementosForm:sobrenome", "Feitosa");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		
		dsl.clicarBotao("elementosForm:cadastrar");
	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoEsporte(){
		dsl.escreve("elementosForm:nome", "Janaina");
		dsl.escreve("elementosForm:sobrenome", "Feitosa");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
	}

}
