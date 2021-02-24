import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormCadastro {
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void cadastrarForm() {
		page.setNome("Janaina");
		page.setSobrenome("Feitosa"); 
		page.setSexoFeminino();
		page.setComidaFrango();
		page.setEscolaridade("Superior");
		page.setEsporte("Natacao");
		page.setSugestao("Nenhuma sugestão.");
		page.cadastrar();
		
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
