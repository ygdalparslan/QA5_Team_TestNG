package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P03_SignInPage {

    public P03_SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);  }

    @FindBy(xpath = "//button[@value='Sign In']")public WebElement signInButton;
    @FindBy(xpath = "//input[@id='username']") public WebElement userNameBox;
    @FindBy(xpath = "//input[@id='password']") public WebElement passwordBox;





}
