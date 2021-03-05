package br.janaina.suites;
import static br.janaina.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.janaina.test.TestFormCadastro;
import br.janaina.test.TestRegras;

@RunWith(Suite.class)
@SuiteClasses({
	TestFormCadastro.class,
	TestRegras.class,
})
public class SuiteTest {
	@AfterClass
	public static void finalizaTudo() {
		killDriver();
	}
}
