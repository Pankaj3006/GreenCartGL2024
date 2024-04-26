package utils;

import static utils.WaitUtilities.waitForClickabilityOf;
import static utils.WaitUtilities.waitForVisibilityOfElement;

import factory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {


    public static void click(WebElement element) {

        waitForClickabilityOf(element).click();
    }

    public static void clearThenInputText(WebElement element, String text) {
        element = waitForClickabilityOf(element);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {

        return waitForVisibilityOfElement(element).getText();
    }

    public static void clickWithJS(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click();", element);
		}

    public static void selectElement(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    private static WebDriver getDriver()
        {
            return DriverFactory.getDriver();
        }
}
