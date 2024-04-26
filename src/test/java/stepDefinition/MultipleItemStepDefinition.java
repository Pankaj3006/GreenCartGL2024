package stepDefinition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.WaitUtilities.unConditionalWait;
import static utils.CommonUtils.click;
import static utils.CommonUtils.getText;
import static utils.CommonUtils.clearThenInputText;
import static utils.CommonUtils.selectElement;
import static utils.DatatableUtils.retrieveDataFromDataTableWithHeader;
import static utils.DatatableUtils.retrieveDataFromDataTableWithOutOrder;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.GreenCartProductPage;
import pages.CartPage;
import pages.PlaceOrderPage;
import pages.ProceedPage;
import pages.ThankYouShoppingPage;
import utils.Constant;
import java.util.List;

public class MultipleItemStepDefinition {

    private WebDriver driver;
    private GreenCartProductPage greenCartProductPage;
    private CartPage cartPage;
    private PlaceOrderPage placeOrderPage;
    private ProceedPage proceedPage;
    private ThankYouShoppingPage thankYouShoppingPage;

    @Given("user is on GreenCart page have multiple Item")
    public void user_is_on_GreenCart_page_have_multiple_item() {
        driver = DriverFactory.getDriver();
        greenCartProductPage = new GreenCartProductPage(driver);
        greenCartProductPage.load("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user should click on add to cart button for multiple product")
    public void user_should_click_on_add_to_cart_button_for_multiple_product(DataTable data) {
        List<String> listOFItemsNeedToAdd =  retrieveDataFromDataTableWithHeader(data);
        for (int i=0; i<listOFItemsNeedToAdd.size(); i++) {
            greenCartProductPage.selectProductByName(listOFItemsNeedToAdd.get(i));
        }
        click(greenCartProductPage.getCart());
    }

    @Then("items present in GreenCart home page should be increased to {int}")
    public void items_present_in_GreenCart_home_page_should_be_increased_to(int int1) {
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getMultipleCartProduct().size(), int1);
    }

    @When("user click  on proceed to checkout button")
    public void user_click_on_proceed_to_checkout_button() {
        click(cartPage.getProceedToCheckOut());
    }

    @Then("place order  page should open")
    public void place_order_page_should_open() {
        placeOrderPage = new PlaceOrderPage(driver);
        unConditionalWait(2000);
    }

    @Then("verify multiple product is added to product table")
    public void verify_multiple_product_is_added_to_product_table(DataTable data) {
        List<String> listOfOrderItems = placeOrderPage.getListOfOrderProducts();
        List<String> listOFItemsNeedToAdd =  retrieveDataFromDataTableWithOutOrder(data);
        Assert.assertTrue(listOfOrderItems.containsAll(listOFItemsNeedToAdd));
    }

    @When("user enter the Code {string} in promoCode TextBox")
    public void user_enter_the_Code_in_promoCode_TextBox(String promoCode) {
        clearThenInputText(placeOrderPage.getPromoCodeTextBox(), promoCode);
    }

    @When("click on apply Button")
    public void click_on_apply_button() {
        click(placeOrderPage.getPromoCodeApplyButton());
    }

    @Then("text {string} is found")
    public void text_is_found(String text) {
        Assert.assertEquals(getText(placeOrderPage.getCodeApplied()), text);
    }

    @When("user click  on place order button")
    public void user_click_on_place_order_button() {
        click(placeOrderPage.getPlaceOrder());
    }

    @Then("proceed page  is open")
    public void proceed_page_is_open() {
        proceedPage = new ProceedPage(driver);
    }

    @Then("choose country  text is found")
    public void choose_country_text_is_found() {
        Assert.assertEquals(getText(proceedPage.getChooseCountry()), Constant.COUNTRY_CHOOSE);
    }

    @When("user click on select country  dropdown and select country from dropdown")
    public void user_click_on_select_country_dropdown_and_select_country_from_dropdown() {
        selectElement(proceedPage.getCountryDropdown(), "India");
    }

    @And("check the term and  condition checkBox")
    public void check_the_term_and_condition_checkBox() {
        click(proceedPage.getTermAndConditionCheckBox());
    }

    @And("click on  proceed button")
    public void click_on_proceed_button() {
        click(proceedPage.getProceedButton());
    }

    @And("thank you message is displayed")
    public void thank_you_message_is_displayed() {
        thankYouShoppingPage = new ThankYouShoppingPage(driver);
        String successMessage = getText(thankYouShoppingPage.getThankYouMessage());
        assertThat(successMessage, containsString(Constant.SUCCESSFUL_MESSAGE));
    }
}
