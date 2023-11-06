package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class P01_HomePage {

    P03_SignInPage p03SignInPage =new P03_SignInPage();

    public P01_HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void performLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        signInButton.click();
        p03SignInPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));
        p03SignInPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));
        p03SignInPage.signInButton.click();
    }

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "/html/body/div[2]/footer/div/section[2]/div/div[2]/div/section/div/div[2]/div/div[2]/div/nav/ul/li[4]/a")
    public WebElement myAccountLink;

    @FindBy(css = "input[aria-label='Search']")
    public WebElement searchBox;

    //input[aria-label='Search']
    //-//div//input[@placeholder='Search'])[1]
    @FindBy(css = "span~i")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div/div/div[3]/div/div/form/div")
    public List<WebElement> getSearchList;


}
