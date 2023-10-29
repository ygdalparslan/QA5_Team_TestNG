package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    public static boolean verifyElementIsVisible(WebElement element) {
        return element.isDisplayed();
    }

}
