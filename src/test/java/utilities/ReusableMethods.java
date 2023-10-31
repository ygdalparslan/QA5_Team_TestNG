package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.P01_HomePage;
import pages.P03_SignInPage;

public class ReusableMethods {

    static P01_HomePage p01HomePage = new P01_HomePage();
    static P03_SignInPage p03SignInPage = new P03_SignInPage();


    public static boolean verifyElementIsVisible(WebElement element) {

        return element.isDisplayed();
    }

    public static void wait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void performLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01HomePage.signInButton.click();
        p03SignInPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));
        p03SignInPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));
        p03SignInPage.signInButton.click();
    }

    public static void verifyData(WebElement element,String expected) {
        String actualDate =element.getText();
        Assert.assertEquals(actualDate,expected);
    }




}
