package runners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        overviewReport = true,
        toPDF = true,
        outputFolder = "target")

@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json","pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features = { "src/test/resources" },
        glue = { "com.gbst.stepdefinitions","com.gbst.runners"},
        tags = {"@RegressionTestNewBusinessJISA"})

public class AcceptanceTest {

    @AfterClass
    public static void emailReport() throws Exception{
        //EmailUtility.sendEmail();
    }
}
