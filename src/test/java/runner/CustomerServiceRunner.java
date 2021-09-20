package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.mockito.Mock;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/stepsdefinitions/" },
                 glue = { "stepsdefinitions" },
                 plugin = { "pretty" }
)
public class CustomerServiceRunner {

}
