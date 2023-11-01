package tests.us04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_SignInPage;
import pages.P04_MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    P01_HomePage p01HomePage =new P01_HomePage();
    P03_SignInPage p03SignInPage =new P03_SignInPage();
    P04_MyAccountPage p04MyAccountPage =new P04_MyAccountPage();
    Faker faker = new Faker();
    Actions actions =new Actions(Driver.driver);


    @Test
    public void testCase02(){


        //1	https://allovercommerce.com/ adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //2	Sign in butonuna tıklar
        p01HomePage.signInButton.click();

        //3	Username or email address ilgili kısıma girilir.
        p03SignInPage.userNameBox.sendKeys(ConfigReader.getProperty("emailAddressSafa"));

        //4	Password ilgili kısıma girilir.
        p03SignInPage.passwordBox.sendKeys(ConfigReader.getProperty("passwordSafa"));

        //5	Sign in butonuna tıklanır
        p03SignInPage.signInButton.click();

        //6	address sekmesine tıklanır
        p01HomePage.myAccountLink.sendKeys(Keys.ENTER);
        p04MyAccountPage.addressLink.click();

        //7	Shipping add address sekmesine tıklanır
        p04MyAccountPage.shippingAddressAddLink.sendKeys(Keys.ENTER);

        //8	First name kutusu boş bırakılır.
        p04MyAccountPage.shippingAddressFirstnameBox.clear();

        //9	 Last name kutusuna soyisim girer
        p04MyAccountPage.shippingAddressLastnameBox.sendKeys(faker.name().lastName());

        //10	Country/Region kutusuna ülke ismi girer.
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Turkey").sendKeys(Keys.TAB).perform();

        //11	Street address kutusuna sokak ve adresini girer.
        p04MyAccountPage.shippingAddressStreetAddressBox.sendKeys("Street address");

        //12	Postcode / ZIP  kutusuna posta kodu girer
        p04MyAccountPage.shippingAddressPostcodeZIPBox.sendKeys("55400");

        //13	Town / City/State  kutusuna kasaba/şehir/eyalet ismi girer.
        p04MyAccountPage.shippingAddressTownCityBox.sendKeys("Town / City");
        actions.sendKeys(Keys.TAB).sendKeys("Samsun").sendKeys(Keys.TAB).perform();

        //14	Save address butonuna tıklanır
        p04MyAccountPage.shippingAddressSaveAddressButton.sendKeys(Keys.ENTER);

        //15  "First name is a required field." metni görülmeli.
        String expectedData ="First name is a required field.";
        ReusableMethods.verifyData(p04MyAccountPage.verifyAddressNotChanged,expectedData);

        Driver.closeDriver();

    }
}
