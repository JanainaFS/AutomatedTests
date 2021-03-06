package br.janaina.test;
import static br.janaina.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;

import br.janaina.core.BaseTest;
import br.janaina.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TestRegras extends BaseTest{
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
		
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][]{
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Janaina", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Janaina", "Feitosa", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Janaina", "Feitosa", "Feminino", Arrays.asList("Frango", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Janaina", "Feitosa", "Feminino", Arrays.asList("Frango"), new String[]{"Natacao", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		
		if(sexo.equals("Feminino")) page.setSexoFeminino();
		if(sexo.equals("Masculino"))	page.setSexoMasculino();
		
		if(comidas.contains("Frango")) page.setComidaFrango();
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariana();
		
		page.setEsporte(esportes);
		
		page.cadastrar();
		System.out.println(msg);
		
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals(msg , alert.getText());
		alert.accept();
	}
	
}
