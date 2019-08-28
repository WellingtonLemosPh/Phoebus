package runners;

//import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"steps"},
		plugin = {"html:target/report-html", "json:target/report.json"},     //Apresenta de forma amigável os resultados
		tags = {"@appium"},
		monochrome = true,                                                            //Retira os caracteris especias dos resultados
		snippets = SnippetType.CAMELCASE,                                            //Muda a forma como o passo é apresentado
		dryRun = false,                                                             //Apresenta ou não a mensagem que tiver no passo
		strict = false                                                             //Ignora ou não um passo especificado
)


public class TestRunner extends AbstractTestNGCucumberTests {
//	@BeforeClass
//	public static void reset() {    //Gerenciamento de massa de dados
//		                           //Estrutura criada para realizar ações após a bateria de testes.
//		                          //Como apagar contas criadas do BD.
//	}
	
}
