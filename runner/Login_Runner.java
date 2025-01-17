package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "C:\\Users\\AC\\eclipse-workspace\\practice\\Practice.feature",
			        glue ="stepdefination",
			        		plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Login_Runner {

}
