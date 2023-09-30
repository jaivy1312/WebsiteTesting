package cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue={"cucumber.stepDefination"},
dryRun=false,
monochrome=true, plugin= {"html:target/cucum.html"})
public class TestNgRunner1 extends AbstractTestNGCucumberTests {

}
