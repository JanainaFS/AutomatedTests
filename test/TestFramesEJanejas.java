package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;
import static br.janaina.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class TestFramesEJanejas {	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void testFrame() {
		getDriver().switchTo().frame("frame1");
		getDriver().findElement(By.id("frameButton")).click();
		Alert alert = getDriver().switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		getDriver().switchTo().defaultContent();
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void testFrameEscondido() {
		getDriver().switchTo().frame("frame2");
		getDriver().findElement(By.id("frameButton")).click();
		Alert alert = getDriver().switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void testJanelasComTitulo() {
		getDriver().findElement(By.id("buttonPopUpEasy")).click();
		getDriver().switchTo().window("Popup");
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		getDriver().close();
		getDriver().switchTo().window("");
		getDriver().findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void testJanelasSemTitulo() {
		getDriver().findElement(By.id("buttonPopUpHard")).click();
		System.out.println(getDriver().getWindowHandle());
		System.out.println(getDriver().getWindowHandles());
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
		getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
	
	
}
