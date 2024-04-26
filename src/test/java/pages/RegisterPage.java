package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver){

		super(driver);
	}

@FindBy(xpath="//*[text()='Join now to Practice']")
private WebElement registerPageText;

@FindBy(xpath="//input[@id='name']")
private WebElement username;

@FindBy(xpath="//input[@id='email']")
private WebElement userEmail;

@FindBy(xpath="//input[@type='checkbox']")
private WebElement checkbox;

@FindBy(xpath="//button[@id='form-submit']")
private WebElement submitButton;

	public WebElement getRegisterPageText() {
		return registerPageText;
	}

	public WebElement getUsername() { return username; }

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getCheckbox() { return checkbox; }

	public WebElement getSubmitButton() {
		return submitButton;
	}
}
