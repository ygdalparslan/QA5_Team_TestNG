package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods {


    public static void verifyElementIsVisible(By locator){

        WebElement element = Driver.driver.findElement(locator);
        assert element.isDisplayed();

    }

}
