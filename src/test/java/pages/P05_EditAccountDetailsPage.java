package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P05_EditAccountDetailsPage {

    public P05_EditAccountDetailsPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[text()='edit your password and account details']")
    public WebElement editYourPasswordAndAccountDetails;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement editAccountDetailsFirstNameBox;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement editAccountDetailsLastNameBox;

    @FindBy(xpath = "//input[@id='account_display_name']")
    public WebElement editAccountDetailsDisplayNameBox;

    @FindBy(xpath = "//input[@id='account_email']")
    public WebElement editAccountDetailsEmailAddressBox;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement editAccountDetailsParagrafBox;

    @FindBy(xpath = "//input[@id='password_current']")
    public WebElement editAccountDetailsPassword_currentBox;

    @FindBy(xpath = "//input[@id='password_1']")
    public WebElement editAccountDetailsNewPasswordBox;

    @FindBy(xpath = "//input[@id='password_2']")
    public WebElement editAccountDetailsConfirmPasswordBox;

    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement editAccountDetailsSave_accountButton;

    @FindBy(xpath = "//i[@class='fas fa-check']")
    public WebElement verifyAccountDetailsChanged;


    //-//input[@id='password_current']

}
