package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/main/java/features/",glue="step",dryRun=false,monochrome=true,plugin= {"pretty"})
public class MainRunner {
	public static void main(String[] args) {
		
	}
}
