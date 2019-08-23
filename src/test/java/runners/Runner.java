package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		plugin = {"html:target/report-html", "json:target/report.json"},     //Apresenta de forma amigável os resultados
		tags = {"@calculadora"},
		monochrome = true,                                                            //Retira os caracteris especias dos resultados
		snippets = SnippetType.CAMELCASE,                                            //Muda a forma como o passo é apresentado
		dryRun = false,                                                             //Apresenta ou não a mensagem que tiver no passo
		strict = false                                                             //Ignora ou não um passo especificado
)


public class Runner {
//	@BeforeClass
	public static void reset() {    //Gerenciamento de massa de dados
		                           //Estrutura criada para realizar ações após a bateria de testes.
		                          //Como apagar contas criadas do BD.
	}
	
}
