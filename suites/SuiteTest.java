package br.janaina.suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.janaina.test.TestCampoTreinamento;
import br.janaina.test.TestFormCadastro;
import br.janaina.test.TestRegras;

@RunWith(Suite.class)
@SuiteClasses({
	TestFormCadastro.class,
	TestRegras.class,
	TestCampoTreinamento.class
})
public class SuiteTest {

}
