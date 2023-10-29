package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P03_SignIn {

    public P03_SignIn() {
        PageFactory.initElements(Driver.getDriver(),this);  }

    @FindBy(xpath = "//*[@id='header']/div/div/div/div/div/div[9]/div/div/a[1]/span")
    public WebElement signInButton;



}
