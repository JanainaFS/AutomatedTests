import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DLS {
	private WebDriver driver;
	
	public DLS(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escreve(String id, String texto) {
		driver.findElement(By.id(id)).sendKeys(texto);
	}

}
