import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps","configuration"},
        plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"})
public class RunnerTest {
}