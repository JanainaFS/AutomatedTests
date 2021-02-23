import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormCadastro {
	
	@Test
	public void cadastrarForm() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Janaina");
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Feitosa");
		
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		
		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
				.selectByVisibleText("Superior");
		
		new Select(driver.findElement(By.id("elementosForm:esportes")))
			.selectByVisibleText("Natacao");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Nenhuma sugestão.");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Janaina", driver.findElement(By.id("descNome")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Feitosa", driver.findElement(By.id("descSobrenome")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Feminino", driver.findElement(By.id("descSexo")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Frango", driver.findElement(By.id("descComida")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("superior", driver.findElement(By.id("descEscolaridade")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Natacao", driver.findElement(By.id("descEsportes")).findElement(By.tagName("span")).getText());
		Assert.assertEquals("Nenhuma sugestão.", driver.findElement(By.id("descSugestoes")).findElement(By.tagName("span")).getText());

		driver.quit();
	}
	
}
