package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GreenCartProductPage extends BasePage {

	public GreenCartProductPage(WebDriver driver){
		super(driver);
	}

@FindBy(xpath="//div[@class='brand greenLogo']")
private WebElement greenCartLogo;

@FindBy(xpath="//div[@class='product']")
private List<WebElement> products;

@FindBy(xpath="//input[@class='search-keyword']")
private WebElement searchBox;

@FindBy(xpath="//h4[@class='product-name']")
private List<WebElement> productNames;

@FindBy(xpath="//a[@class='cart-icon']")
private WebElement cart;

@FindBy(xpath="//tr[1]/td[3]/strong")
private WebElement countOnCart;

	public WebElement getGreenCartLogo() {
		return greenCartLogo;
	}

	public List<WebElement> getProductNames() {
		return productNames;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getCountOnCart() {
		return countOnCart;
	}

	public void selectProductByName(String productName)
	{
		for(int i = 1; i<= getProductNames().size(); i++) {
			if(getProductNames().get(i-1).getText().contains(productName))
			{
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div["+i+"]/div[3]/button")).click();
				break;
			}
		}
	}
}