import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
	
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
	public void clickButtonAlert() {
		dsl.clicarBotao("alert");
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		dsl.escreve("elementosForm:nome", texto);
	}
	
	@Test
	public void clickButtonAlertConfirm() {
		dsl.clicarBotao("confirm");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		dsl.clicarBotao("confirm");
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.dismiss();
	}
	
	@Test
	public void clickButtonAlertPropt() {
		dsl.clicarBotao("prompt");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("8");
		alert.accept();
		Assert.assertEquals("Era 8?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}
}
