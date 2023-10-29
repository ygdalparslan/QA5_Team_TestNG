package tests.us01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
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
        String homePage =Driver.getDriver().getWindowHandle();

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
//        String lastPage =Driver.getDriver().getWindowHandle();
//
//        System.out.println("homePage = " + homePage);
//        System.out.println("lastPage = " + lastPage);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //8	Kayıt işleminin gerçekleşmediğini doğrula
        String str=Driver.getDriver().switchTo().alert().getText();



    }
}
