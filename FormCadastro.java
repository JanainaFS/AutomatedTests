import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormCadastro {
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
	public void cadastrarForm() {
		dsl.escreve("elementosForm:nome", "Janaina");
		dsl.escreve("elementosForm:sobrenome", "Feitosa");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.escreve("elementosForm:sugestoes", "Nenhuma sugestão.");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		//Refatorar depois
		Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Janaina", driver.findElement(By.id("descNome")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Feitosa", driver.findElement(By.id("descSobrenome")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Feminino", driver.findElement(By.id("descSexo")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Frango", driver.findElement(By.id("descComida")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("superior", driver.findElement(By.id("descEscolaridade")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Natacao", driver.findElement(By.id("descEsportes")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Nenhuma sugestão.", driver.findElement(By.id("descSugestoes")).findElement(By.tagName("span")).getText());
	}
	
}
