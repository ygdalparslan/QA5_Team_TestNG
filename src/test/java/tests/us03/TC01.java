package tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_SignInPage;
import pages.P04_MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TC01 {

    P01_HomePage p01HomePage =new P01_HomePage();
    P03_SignInPage p03SignInPage =new P03_SignInPage();
    P04_MyAccountPage p04MyAccountPage =new P04_MyAccountPage();
    Faker faker =new Faker();

    Actions actions =new Actions(Driver.driver);
    @Test
    public void testCase01() {

        //1	Web sitesine gidilir.
        //2	Log in yapılır.
        p01HomePage.performLogin();

        //3	Site sayfasında el alt kısımda yer alan "my account" tıklanır.
        p01HomePage.myAccountLink.sendKeys(Keys.ENTER);

        //4	"Addresses" butonuna tıklanır.
        p04MyAccountPage.addressLink.click();

        //5	Billing Address kısmının altında yer alan "ADD-->" butonuna tıklanır.
        p04MyAccountPage.addressAddLink.sendKeys(Keys.ENTER);

        //6	"First name" kutusu doldurulur.
        p04MyAccountPage.billingFirstNameBox.sendKeys(faker.name().firstName());

        //7	"Last name" kutusu doldurulur.
        p04MyAccountPage.billingLastNameBox.sendKeys(faker.name().lastName());

        //8	"Company name (optional)" kutusu doldurulur.
        p04MyAccountPage.billingCompanyNameBox.sendKeys("uA Holding");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Turkey")//9	"Country / Region" kısmından ilgili alan seçilir.
               .sendKeys(Keys.TAB).perform();

        //10	"Street address" kutusu doldurulur.
        p04MyAccountPage.billingStreetAddressBox.sendKeys("55 / Akkent");

        //11	"Postcode / ZIP" kutusu doldurulur.
        p04MyAccountPage.billingPostcodeZipBox.sendKeys("06400");

        //12	"Town / City" kutusu doldurulur.
        p04MyAccountPage.billingTownCityBox.sendKeys("Yenimahalle");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Samsun").sendKeys(Keys.TAB).perform();//14	"Province" kısmından ilgili alan seçilir.

        //13	"Phone"  kutusu doldurulur
        p04MyAccountPage.billingPhoneNumberBox.sendKeys("5060606060");
        actions.sendKeys(Keys.TAB).perform();

        //15	"Email address" kutusu doldurulur.
        // otomatik dolu olarak geldiği için boş bırakıldı

        //16	"SAVE ADDRESS" butonuna tıklanır.
        p04MyAccountPage.billingSaveAddressButton.sendKeys(Keys.ENTER);

        //17 "Address changed successfully." yazısı yazmalı ve fatura adresinin kayıt işlemi gerçekleşmeli
        Assert.assertTrue(p04MyAccountPage.addressChangedSuccessfully.isDisplayed());

        Driver.closeDriver();

    }
}
