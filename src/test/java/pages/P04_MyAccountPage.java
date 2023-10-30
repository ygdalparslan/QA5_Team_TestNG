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
    @FindBy(id = "#billing_last_name") public WebElement billingLastNameBox;
    @FindBy(id = "#billing_company") public WebElement billingCompanyNameBox;
    @FindBy(id = "#select2-billing_country-container") public WebElement billingCountryContainerNameBox;


}
