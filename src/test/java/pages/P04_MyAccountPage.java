package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P04_MyAccountPage {

    public P04_MyAccountPage() {PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "//a[text()='Addresses']") public WebElement addressLink;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a") public WebElement addressAddLink;

    @FindBy(xpath = "//*[@id='billing_first_name']") public WebElement billingFirstNameBox;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[2]/span/input")
    public WebElement billingLastNameBox;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[3]/span/input")
    public WebElement billingCompanyNameBox;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[4]/span/span/span[1]/span/span[1]/span")
    public WebElement billingCountryContainerNameBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[5]/span/input")
    public WebElement billingStreetAddressBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[7]/span/input")
    public WebElement billingPostcodeZipBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[8]/span/input")
    public WebElement billingTownCityBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[10]/span/input")
    public WebElement billingPhoneNumberBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/div/p[9]/span/span/span[1]/span/span[1]/span")
    public WebElement billingProvinceBox;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div/div/form/div/p/button")
    public WebElement billingSaveAddressButton;



}
