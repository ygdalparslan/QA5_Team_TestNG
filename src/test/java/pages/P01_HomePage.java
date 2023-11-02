package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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
