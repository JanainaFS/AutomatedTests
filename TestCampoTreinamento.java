import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCampoTreinamento {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void testeCampoTreinamento() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void verificarMarcacaoRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
	}
	
	@Test
	public void verificarMarcacaoCheckboxButton() {
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
	}
	
	@Test
	public void selecionarCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(4);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	public void selecionarComboOne() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
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
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void clickBotao() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void clickLink() {
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void buscarTextoPag() {
		Assert.assertEquals("Campo de Treinamento",
				driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());	
	}
}





