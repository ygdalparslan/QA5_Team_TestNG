package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.P01_HomePage;
import pages.P03_SignInPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    P01_HomePage p01HomePage = new P01_HomePage();
    P03_SignInPage p03SignInPage = new P03_SignInPage();

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // Full path to the screenshot location
        String target = System.getProperty("user.dir") + "/reports/screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return target;
    }

    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }



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

//    public static void performLogin() {// P01_HomePage'taşındı
//        Driver.getDriver().get(ConfigReader.getProperty("URL"));
//        p01HomePage.signInButton.click();
//        p03SignInPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));
//        p03SignInPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));
//        p03SignInPage.signInButton.click();
//    }


    public static void verifyData(WebElement element,String expected) {
        String actualDate =element.getText();
        Assert.assertEquals(actualDate,expected);
    }

    public static void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



}
