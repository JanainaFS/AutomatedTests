import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegras {
	
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
	public void validacaoNome() {
		page.cadastrar();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoSobrenome() {
		page.setNome("Janaina");
		
		page.cadastrar();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoSexo() {
		page.setNome("Janaina");
		page.setSobrenome("Feitosa"); 
		
		page.cadastrar();

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoComida() {
		page.setNome("Janaina");
		page.setSobrenome("Feitosa"); 
		page.setSexoFeminino();
		page.setComidaFrango();
		page.setComidaVegetariana();
		
		page.cadastrar();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	}
	
	@Test
	public void validacaoEsporte(){
		page.setNome("Janaina");
		page.setSobrenome("Feitosa"); 
		page.setSexoFeminino();
		page.setComidaFrango();
		page.setEsporte("Natacao", "O que eh esporte?");
		
		page.cadastrar();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
	}

}
