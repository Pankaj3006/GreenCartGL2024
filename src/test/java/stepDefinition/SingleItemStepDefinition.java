package stepDefinition;

import static utils.CommonUtils.click;
import static utils.CommonUtils.clickWithJS;
import static utils.CommonUtils.getText;
import static utils.CommonUtils.clearThenInputText;
import static utils.CommonUtils.selectElement;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import pages.AutomationProjectPage;
import pages.GreenCartProductPage;
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.ProceedPage;
import pages.ThankYouShoppingPage;
import utils.Constant;
import utils.WaitUtilities;

public class SingleItemStepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private AutomationProjectPage automationProjectPage;
    private GreenCartProductPage greenCartProductPage;
    private CartPage cartPage;
    private PlaceOrderPage placeOrderPage;
    private ProceedPage proceedPage;
    private ThankYouShoppingPage thankYouShoppingPage;

    @Given("user is on Home page")
    public void user_is_on_home_page() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.load("https://rahulshettyacademy.com/");
    }

    @When("user click on practice link")
    public void user_click_on_practice_link() {
        click(homePage.getPracticeLink());
    }

    @Then("user move towards register page")
    public void user_move_towards_register_page() {
        String registerPageTitle = driver.getTitle();
        Assert.assertEquals(registerPageTitle, Constant.REGISTER_PAGE_TITLE);
    }

    @And("validate {string} text on register page")
    public void validate_text_on_register_page(String text) {
        registerPage = new RegisterPage(driver);
        String act_Text = getText(registerPage.getRegisterPageText());
        Assert.assertEquals(act_Text, text);
    }

    @Given("user is on Register page")
    public void user_is_on_Register_page() {
        driver = DriverFactory.getDriver();
        registerPage = new RegisterPage(driver);
        registerPage.load("https://rahulshettyacademy.com/practice-project");
    }

    @When("user gives name as {string} and email as {string}")
    public void user_gives_name_and_email(String name, String email) {
        clearThenInputText(registerPage.getUsername(), name);
        clearThenInputText(registerPage.getUserEmail(), email);
        click(registerPage.getCheckbox());
        click(registerPage.getSubmitButton());
    }

    @Then("validate automation project page is open")
    public void validate_automation_practice_page_is_open() {
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, Constant.REGISTER_PAGE_TITLE);
    }

    @And("validate text")
    public void validate_text() {
       // unConditionalWait(2000);
        automationProjectPage = new AutomationProjectPage(driver);
        String automationPageTitle = getText(automationProjectPage.getOurProjectText());
        Assert.assertEquals(automationPageTitle, Constant.AUTOMATION_PAGE_TITLE);
    }

    @When("user click on automation practice link1")
    public void user_click_on_automation_practice_link1() {
        clickWithJS(automationProjectPage.getAutomationPracticeLink());
    }

    @Then("GreenCart product page is open")
    public void GreenCart_product_page_is_open() {
        String greenCartPageTitle = driver.getTitle();
        Assert.assertEquals(greenCartPageTitle, Constant.GREENKART_PAGE_TITLE);
    }

    @And("logo is found {string}")
    public void logo_is_found(String greenCartPageLogo) {
        greenCartProductPage = new GreenCartProductPage(driver);
        String actualLogoText = getText(greenCartProductPage.getGreenCartLogo());
        Assert.assertEquals(actualLogoText, greenCartPageLogo);
    }

    @Given("user is on GreenCart page")
    public void user_is_on_GreenCart_page() {
        driver = DriverFactory.getDriver();
        greenCartProductPage = new GreenCartProductPage(driver);
        greenCartProductPage.load("https://rahulshettyacademy.com/seleniumPractise/#/");
    }


    @When("user click on add to cart button for desired {word}")
    public void user_click_on_add_to_cart_button_for_desired(String productName) {
        greenCartProductPage.selectProductByName(productName);
        click(greenCartProductPage.getCart());
        cartPage = new CartPage(driver);
        click(cartPage.getProceedToCheckOut());
    }

    @Then("{word} added to the cart and Receives Thank you Message")
    public void added_to_the_cart(String expectedItem) {
        placeOrderPage = new PlaceOrderPage(driver);
        WaitUtilities.unConditionalWait(2000);
        String addedItem = placeOrderPage.getListOfOrderProducts().get(0);
        Assert.assertEquals(addedItem, expectedItem);
        clearThenInputText(placeOrderPage.getPromoCodeTextBox(), "rahulshettyacademy");
        click(placeOrderPage.getPromoCodeApplyButton());
        Assert.assertEquals(getText(placeOrderPage.getCodeApplied()), Constant.CODE_APPLIED);
        click(placeOrderPage.getPlaceOrder());
        proceedPage = new ProceedPage(driver);
        Assert.assertEquals(getText(proceedPage.getChooseCountry()), Constant.COUNTRY_CHOOSE);
        selectElement(proceedPage.getCountryDropdown(), "India");
        click(proceedPage.getTermAndConditionCheckBox());
        click(proceedPage.getProceedButton());
        thankYouShoppingPage = new ThankYouShoppingPage(driver);
        String successMessage = getText(thankYouShoppingPage.getThankYouMessage());
        assertThat(successMessage, containsString(Constant.SUCCESSFUL_MESSAGE));
    }
}
