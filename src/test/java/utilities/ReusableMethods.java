package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    public static boolean verifyElementIsVisible(WebElement element) {
        return element.isDisplayed();
    }

    public static void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
