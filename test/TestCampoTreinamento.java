package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.janaina.core.DSL;

public class TestCampoTreinamento {
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
	public void testeCampoTreinamento() {
		dsl.escreve("elementosForm:nome", "Teste de escrita");
		dsl.obterValorCampo("elementosForm:nome");
	}
	
	@Test
	public void escreverNomeDuplo() {
		dsl.escreve("elementosForm:nome", "Janaina");
		Assert.assertEquals("Janaina", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Feitosa");
		Assert.assertEquals("Feitosa", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escreve("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void verificarMarcacaoRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:1");
		Assert.assertTrue(dsl.verificarRadioSelecionado("elementosForm:sexo:1"));
	}
	
	@Test
	public void verificarMarcacaoCheckboxButton() {
		getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Assert.assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
	}
	
	@Test
	public void selecionarCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void selecionarComboOne() {
		WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options =  combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Superior")) {
				encontrou = true;
				break;
				
			}
		}
		
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void selecionarValoresMultiplos() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void clickBotao() {
		dsl.clicarBotao("buttonSimple");
		
		WebElement botao = getDriver().findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void clickLink() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void buscarTextoPag() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
	
	//Código JavaScript no Selenium
	@Test
	public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
	}
}





