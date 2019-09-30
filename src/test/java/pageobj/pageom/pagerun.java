package pageobj.pageom;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
plugin= {"json:src/test/java/pageobj.pageom/result.json"}
)
public class pagerun 
{
	
}
