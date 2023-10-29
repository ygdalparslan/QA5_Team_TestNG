package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P02_RegisterPage {
    public P02_RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='reg_password']") public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='register-policy']") public WebElement privacyPolicyBox;

    @FindBy(xpath = "//button[@name='register']") public WebElement signUpButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[1]") public WebElement enterValidAccountUsername;
    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']") public WebElement accountIsAlreadyRegistered;

}
