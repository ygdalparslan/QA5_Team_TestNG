package tests.us02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportUtil;
import utilities.ReusableMethods;

public class TC03 {

    private final String testName = "US02 || TC03-Kullanıcı Daha Önceki Username İle kayıt Olamamalı";
    private final String description = "Siteye Daha Önceki Username İle kayıt Olunamamalıdır.";
    private final String raporMesaji = "Kullanıcı kayıt olamamıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase(){

        P01_HomePage p01HomePage = new P01_HomePage();
        P02_RegisterPage p02RegisterPage = new P02_RegisterPage();

        //1	Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi.");

        //2	Register butonuna tıklanır
        p01HomePage.registerButton.click();
        ExtentReportUtil.extentTestInfo("Register Butonuna Tıklandı.");

        //3	Username alanına  username girilir
        p02RegisterPage.userNameBox.sendKeys(ConfigReader.getProperty("usernameRegister"));
        ExtentReportUtil.extentTestInfo("Username Girildi.");

        //4	Your Email address alanına kayıt olurken girdiği Email'i girer
        p02RegisterPage.emailBox.sendKeys(ConfigReader.getProperty("emailAddressRegister"));
        ExtentReportUtil.extentTestInfo("Email Girildi.");

        //5	Password  alanına  password girilir
        p02RegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordRegister"));
        ExtentReportUtil.extentTestInfo("Password Girildi.");

        //6	"I agree to the privacy policy" kutusu işaretlenir
        p02RegisterPage.privacyPolicyBox.click();
        ExtentReportUtil.extentTestInfo("I Agree To The Privacy Policy Kutusu  İişaretlendi.");

        //7	Sign in butonuna tıklanır
        p02RegisterPage.signUpButton.click();
        ExtentReportUtil.extentTestInfo("Sign In Butonuna Tıklandı.");

        //8	Kayıt işleminin tamamlanmadığını doğrula
        Assert.assertTrue(p02RegisterPage.accountIsAlreadyRegistered.isDisplayed());
        ExtentReportUtil.extentTestInfo("Kayıt İşleminin Tamamlanmadığı Doğrulandı.");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
