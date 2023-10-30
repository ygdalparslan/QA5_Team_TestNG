package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P01_HomePage {

    public P01_HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//div/nav/ul/li/a[text()='My Account']") public WebElement myAccountLink;




}
