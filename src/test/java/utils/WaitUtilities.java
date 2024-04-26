package utils;

import factory.DriverFactory;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtilities {

    public static void unConditionalWait(long duration)
    {
        try{
            Thread.sleep(duration);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public static WebElement waitForClickabilityOf(WebElement element) {

        return waitForClickabilityOf(element, Constant.TO_BE_CLICKABLE);
    }

    public static WebElement waitForClickabilityOf(WebElement element, long timeToWaitInSec) {

        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeToWaitInSec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibilityOfElement(WebElement element) {

        return waitForVisibilityOf(element, Constant.TO_BE_VISIBLE);
    }

    public static WebElement waitForVisibilityOf(WebElement element, long timeToWaitInSec) {

        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeToWaitInSec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
