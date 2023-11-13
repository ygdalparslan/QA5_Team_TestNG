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

    P03_SignInPage p03SignInPage = new P03_SignInPage();

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

    @FindBy(xpath = "//li/a[text()='Electronics']")
    public WebElement electronicsKategori;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement birinciUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[2]")
    public WebElement ikinciUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[2]")
    public WebElement ucuncuUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[2]")
    public WebElement dorduncuUrun;
    @FindBy(xpath = "//a[.='Start Compare !']")
    public WebElement startCompareButton;

    @FindBy(xpath = "//div[@class='compare-basic-info']")
    public List<WebElement> compareList;
}
