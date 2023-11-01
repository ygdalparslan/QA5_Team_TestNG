package tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P04_MyAccountPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    P01_HomePage p01HomePage =new P01_HomePage();
    P04_MyAccountPage p04MyAccountPage =new P04_MyAccountPage();
    Faker faker =new Faker();
    Actions actions =new Actions(Driver.driver);

    @Test
    public void testCase02(){

        //1	Web sitesine gidilir.
        //2	Log in yapılır.
        ReusableMethods.performLogin();

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

        //9	"Country / Region" kısmından ilgili alan seçilir.
        actions.sendKeys(Keys.TAB).sendKeys("Turkey").sendKeys(Keys.TAB).perform();

        //10	"Street address" kutusu doldurulur.
        p04MyAccountPage.billingStreetAddressBox.sendKeys("55 / Akkent");

        //11	"Postcode / ZIP" kutusu doldurulur.
        p04MyAccountPage.billingPostcodeZipBox.sendKeys("06400");

        //12	"Town / City" kutusu doldurulur.
        p04MyAccountPage.billingTownCityBox.sendKeys("Yenimahalle");

        //14	"Province" kısmından ilgili alan seçilir.
        actions.sendKeys(Keys.TAB).sendKeys("Samsun").sendKeys(Keys.TAB).perform();

        //13	"Phone"  kutusu doldurulur
        p04MyAccountPage.billingPhoneNumberBox.sendKeys("5060606060");

        //15	"Email address" kutusu boş bırakılır.
        p04MyAccountPage.billingEmailBox.clear();

        //16	"SAVE ADDRESS" butonuna tıklanır.
        p04MyAccountPage.billingSaveAddressButton.sendKeys(Keys.ENTER);

        //Kayıt işleminin gerçekleşmediğini doğrula. "Email address is a required field." metni görülmeli
        String expectedData= "Email address is a required field.";
        ReusableMethods.verifyData(p04MyAccountPage.verifyAddressNotChanged,expectedData);

        Driver.closeDriver();

    }
}
