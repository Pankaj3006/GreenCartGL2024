package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static HomePage homePage;
    private static RegisterPage registerPage;
    private static AutomationProjectPage automationProjectPage;
    private static GreenCartProductPage greenCartProductPage;
    private static CartPage cartPage;
    private static PlaceOrderPage placeOrderPage;
    private static ProceedPage proceedPage;
    private static ThankYouShoppingPage thankYouShoppingPage;

    public static HomePage getHomePage(WebDriver driver) {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static RegisterPage getRegisterPage(WebDriver driver) {
        return registerPage == null ? new RegisterPage(driver) : registerPage;
    }

    public static AutomationProjectPage getAutomationProjectPage(WebDriver driver) {
        return automationProjectPage == null ? new AutomationProjectPage(driver) : automationProjectPage;
    }

    public static GreenCartProductPage getGreenCartProductPage(WebDriver driver) {
        return greenCartProductPage == null ? new GreenCartProductPage(driver) : greenCartProductPage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static PlaceOrderPage getPlaceOrderPage(WebDriver driver) {
        return placeOrderPage == null ? new PlaceOrderPage(driver) : placeOrderPage;
    }

    public static ProceedPage getProceedPage(WebDriver driver) {
        return proceedPage == null ? new ProceedPage(driver) : proceedPage;
    }

    public static ThankYouShoppingPage getThankYouShoppingPage(WebDriver driver) {
        return thankYouShoppingPage == null ? new ThankYouShoppingPage(driver) : thankYouShoppingPage;
    }
}
