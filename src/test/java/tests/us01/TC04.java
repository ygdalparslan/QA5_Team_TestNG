package tests.us01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    P01_HomePage p01HomePage =new P01_HomePage();
    P02_RegisterPage p02RegisterPage =new P02_RegisterPage();
    Faker faker =new Faker();

    @Test
    public void testCase04(){

        //1	Verilen URL'e git
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //2	Register linkine tıkla
        p01HomePage.registerButton.click();

        //3	Username kutusuna bir kulanıcı adı gir
        p02RegisterPage.userNameBox.sendKeys(faker.name().username());

        //4	Your Email address kutusuna bir eposta gir
        p02RegisterPage.emailBox.sendKeys(faker.internet().emailAddress());

        //5	Password kutusunu boş bırak

        //6	I agree to the privacy policy kutusunu işaretle
        p02RegisterPage.privacyPolicyBox.click();

        //7	SIGN UP butonuna tıkla
        p02RegisterPage.signUpButton.click();

        //8	Kayıt işleminin gerçekleşmediğini doğrula
        ReusableMethods.verifyElementIsVisible(p02RegisterPage.signUpButton);

        Driver.closeDriver();

    }
}
