package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin= {"pretty","html:target/cucumber.html"},
        glue={"stepDefinition"},
        features="src/test/java",
        tags = "@Scenario1 or @Scenario2 or @Scenario3 or @whole1"
)

public class JunitRunnerTest {
}
