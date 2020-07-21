package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\feature",
        glue = "cucumber",
        tags = "@Feature"
)
public class RunTest extends AbstractTestNGCucumberTests {
}
