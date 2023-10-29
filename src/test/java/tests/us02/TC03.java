package tests.us02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {

    P01_HomePage p01HomePage = new P01_HomePage();
    P02_RegisterPage p02RegisterPage = new P02_RegisterPage();
    Faker faker = new Faker();

    @Test
    public void testCase(){

        //1	Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //2	Register butonuna tıklanır
        p01HomePage.registerButton.click();

        //3	Username alanına  username girilir
        p02RegisterPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));

        //4	Your Email address alanına kayıt olurken girdiği Email'i girer
        p02RegisterPage.emailBox.sendKeys(ConfigReader.getProperty("emailAddressRegister"));

        //5	Password  alanına  password girilir
        p02RegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));

        //6	"I agree to the privacy policy" kutusu işaretlenir
        p02RegisterPage.privacyPolicyBox.click();

        //7	Sign in butonuna tıklanır
        p02RegisterPage.signUpButton.click();

        //8	Kayıt işleminin tamamlanmadığını doğrula
        Assert.assertTrue(p02RegisterPage.accountIsAlreadyRegistered.isDisplayed());

        Driver.closeDriver();

    }
}
