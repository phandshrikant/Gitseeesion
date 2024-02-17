package jarvis;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="C:\\Users\\yogesh\\eclipse-workspace\\jarvis\\src\\test\\resources\\Features",glue="com.jarvis.stepdefinations")
public class TestRunner extends AbstractTestNGCucumberTests {

}
