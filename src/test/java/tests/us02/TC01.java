package tests.us02;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    P01_HomePage p01HomePage = new P01_HomePage();
    P02_RegisterPage p02RegisterPage = new P02_RegisterPage();
    Faker faker = new Faker();

    @Test
    public void testCase01() {

        //1	Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //2	Register butonuna tıklanır
        p01HomePage.registerButton.click();

        //3	Username alanına kayıt olurken girdiği username girilir
        p02RegisterPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));

        //4	Your Email address alanına kayıt olurken girdiği Email girilir
        p02RegisterPage.emailBox.sendKeys(ConfigReader.getProperty("emailAddressRegister"));//alejandro.jast@gmail.com

        //5	Password  alanına kayıt olurken girdiği password girilir
        p02RegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));//otha.schaefer1+

        //6	"I agree to the privacy policy" kutusu  işaretlenir
        p02RegisterPage.privacyPolicyBox.click();

        //7	Sign in butonuna tıklanır
        p02RegisterPage.signUpButton.click();

        //8	Kayıt işleminin tamamlanmadığını doğrula
        ReusableMethods.verifyElementIsVisible(p02RegisterPage.accountIsAlreadyRegistered);

    }
}
