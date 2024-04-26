package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderPage extends BasePage{

	public PlaceOrderPage(WebDriver driver){
		super(driver);
	}

@FindBy(xpath="//*[@id='productCartTables']/tbody/tr")
private List<WebElement> NumberOfRows;

@FindBy(xpath="//button[text()='Place Order']")
private WebElement placeOrder;

@FindBy(css=".promoCode")
private WebElement promoCodeTextBox;

@FindBy(css=".promoBtn")
private WebElement promoCodeApplyButton;

@FindBy(xpath="//span[@class='promoInfo']")
private WebElement codeApplied;

	public List<WebElement> getNumberOfRows() {
		return NumberOfRows;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public WebElement getPromoCodeTextBox() {
		return promoCodeTextBox;
	}

	public WebElement getPromoCodeApplyButton() {
		return promoCodeApplyButton;
	}

	public WebElement getCodeApplied() {
		return codeApplied;
	}

	public List<String> getListOfOrderProducts() {
		List<String> listOFAddedItems = new ArrayList<String>();
		for(int i = 1; i<= getNumberOfRows().size(); i++){
			String item=driver.findElement(By.xpath("//*[@id='productCartTables']/tbody/tr["+i+"]/td[2]")).getText().split("-")[0].trim();
			listOFAddedItems.add(item);
		}
		return listOFAddedItems;
	}
}
