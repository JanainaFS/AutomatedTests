import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Regras {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void validacaoNome() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void validacaoSobrenome() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Janaina");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void validacaoSexo() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Janaina");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Feitosa");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void validacaoComida() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Janaina");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Feitosa");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
		
		driver.quit();
		
	}
	
	@Test
	public void validacaoEsporte(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Janaina");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Feitosa");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();

		driver.quit();
	
	}

}
