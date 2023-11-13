package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P06_ShoppingPage {

    public P06_ShoppingPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='main']/div/div/div/div[4]/ul/li[2]/div/figure/div/a[1]")
    public WebElement addToCartButton;

    @FindBy (xpath = "//a[@class='cart-toggle']")
    public WebElement cartButton;

    // Sonraki kullanımlar gerekli olur diye olşturuldu
    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement cartCheckoutButton;

    @FindBy (xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement cartButtonDetailQuantityPlus;

    @FindBy (xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement cartButtonDetailQuantityMinus;

    @FindBy(xpath = "//a[text()='View cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//h4[text()='Shipping']")
    public WebElement shippingText;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(id = "payment_method_bacs")
    public WebElement paymentMethodsWireTransfer;

    @FindBy(id = "payment_method_cod")
    public WebElement paymentMethodsPayAtTheDoor;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement verfyOrderReceived;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    public WebElement quantity;

}
