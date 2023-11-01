package tests.us05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_SignInPage;
import pages.P04_MyAccountPage;
import pages.P05_EditAccountDetailsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    P01_HomePage p01HomePage =new P01_HomePage();
    P03_SignInPage p03SignInPage =new P03_SignInPage();
    P04_MyAccountPage p04MyAccountPage =new P04_MyAccountPage();

    P05_EditAccountDetailsPage p05EditAccountDetailsPage=new P05_EditAccountDetailsPage();

    Faker faker =new Faker();

    @Test
    public void testCase04(){

        //1	Web sitesine gidilir	https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //2	Sıgn In butonuna tıklanır ve geçerli değerlerle hesaba giriş yapılır	qa5serhan@gmail.com & Serhan123456.

        p01HomePage.signInButton.click();
        p03SignInPage.userNameBox.sendKeys(ConfigReader.getProperty("emailAddressSerhan"));
        p03SignInPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordSerhan"));
        p03SignInPage.signInButton.click();

        //3	My Account'a tıklanır
        p01HomePage.myAccountLink.sendKeys(Keys.ENTER);

        //4	"Edit your password and account details" yazısına tıklanır
        p05EditAccountDetailsPage.editYourPasswordAndAccountDetails.click();

        //5	First name kutucuğu doldurulur
        p05EditAccountDetailsPage.editAccountDetailsFirstNameBox.sendKeys(faker.name().firstName());

        //6	Last name kutucuğu doldurulur
        p05EditAccountDetailsPage.editAccountDetailsLastNameBox.sendKeys(faker.name().lastName());

        //7	Display name kutucuğu boş bırakılır
        p05EditAccountDetailsPage.editAccountDetailsDisplayNameBox.clear();
        //p05EditAccountDetailsPage.editAccountDetailsDisplayNameBox.sendKeys(faker.name().username());

        //8	Email address kutucuğuna yeni değerler girilir	{Email adresi}
        p05EditAccountDetailsPage.editAccountDetailsEmailAddressBox.clear();
        p05EditAccountDetailsPage.editAccountDetailsEmailAddressBox.sendKeys(faker.internet().emailAddress());

        //9	Paragraf kutucuğuna değerler girilir
        Driver.getDriver().switchTo().frame("user_description_ifr");
        p05EditAccountDetailsPage.editAccountDetailsParagrafBox.sendKeys(faker.lorem().paragraph());

        //10	"Current password" kutucuğuna mevcut parola girilir	Serhan123456.
        Driver.getDriver().switchTo().parentFrame();
        p05EditAccountDetailsPage.editAccountDetailsPassword_currentBox.sendKeys(ConfigReader.getProperty("passwordSerhan"));

        //11	"New password" kutucuğuna yeni ve geçerli bir parola girilir	Serhan12345.
        p05EditAccountDetailsPage.editAccountDetailsNewPasswordBox.sendKeys("Serhan12345.");

        //12	"Comfirm password" kutucuğuna "new password"a girilen parola girilir	Serhan12345.
        p05EditAccountDetailsPage.editAccountDetailsConfirmPasswordBox.sendKeys("Serhan12345.");

        //13	"SAVE CHANGES" butonuna tıklanır
        p05EditAccountDetailsPage.editAccountDetailsSave_accountButton.sendKeys(Keys.ENTER);

        //14	Değişiklik işleminin tamamlandığı doğrulanır->DISPLAY NAME is a required field.
        String expectedData="DISPLAY NAME is a required field.";
        ReusableMethods.verifyData(p04MyAccountPage.verifyAddressNotChanged,expectedData);

        Driver.closeDriver();


    }
}
