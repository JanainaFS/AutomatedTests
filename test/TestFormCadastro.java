package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.janaina.core.BaseTest;
import br.janaina.page.CampoTreinamentoPage;

public class TestFormCadastro extends BaseTest {
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@Test
	public void cadastrarForm() {
		page.setNome("Janaina");
		page.setSobrenome("Feitosa"); 
		page.setSexoFeminino();
		page.setComidaFrango();
		page.setEscolaridade("Superior");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		//Refatorar depois
//		Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Janaina", driver.findElement(By.id("descNome")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Feitosa", driver.findElement(By.id("descSobrenome")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Feminino", driver.findElement(By.id("descSexo")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Frango", driver.findElement(By.id("descComida")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("superior", driver.findElement(By.id("descEscolaridade")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Natacao", driver.findElement(By.id("descEsportes")).findElement(By.tagName("span")).getText());
//		Assert.assertEquals("Nenhuma sugestão.", driver.findElement(By.id("descSugestoes")).findElement(By.tagName("span")).getText());
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Janaina", page.obterNomeCadastro());
		Assert.assertEquals("Feitosa", page.obterSobrenomeCadastro());
		Assert.assertEquals("Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Frango", page.obterComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
		
}
