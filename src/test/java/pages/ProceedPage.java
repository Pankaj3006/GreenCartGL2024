package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProceedPage extends BasePage {

	public ProceedPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//label[text()='Choose Country']")
	private WebElement chooseCountry;

	@FindBy(xpath="//select[@style='width: 200px;']")
	private WebElement countryDropdown;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement termAndConditionCheckBox;

	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceedButton;

	public WebElement getChooseCountry() {
		return chooseCountry;
	}

	public WebElement getCountryDropdown() { return countryDropdown; }

	public WebElement getTermAndConditionCheckBox() { return termAndConditionCheckBox; }

	public WebElement getProceedButton() { return proceedButton; }
}
