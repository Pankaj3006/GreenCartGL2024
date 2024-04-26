package stepDefinition;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Hooks {

	private WebDriver driver;

	@Before
	public void beforeSingleItemScenarios() {
		driver = DriverFactory.initializeDriver();
	}

	@After
	public void afterSingleItemScenarios() {
		driver.quit();
	}

@After
public void addScreenshot(Scenario scenario) throws WebDriverException, IOException {
	
	if(scenario.isFailed())
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\src\\test\\java\\screenshot\\"+scenario.getName()+".jpeg";
		FileUtils.copyFile(source, new File(destination));
	}
}
}
