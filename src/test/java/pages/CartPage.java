package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li/div[1]/p[1]")
	private List<WebElement> multipleCartProduct;

	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	private WebElement proceedToCheckOut;

	public List<WebElement> getMultipleCartProduct() { return multipleCartProduct; }

	public WebElement getProceedToCheckOut() { return proceedToCheckOut; }
}
