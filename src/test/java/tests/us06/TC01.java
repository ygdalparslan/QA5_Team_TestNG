package tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P06_ShoppingPage;
import utilities.Driver;
import utilities.ExtentReportUtil;
import utilities.ReusableMethods;

import java.util.List;

public class TC01 {

    private final String testName = "US06 || TC01-Kullanıcı arama kutusundan istediği ürünü arayabilmeli";
    private final String description = "Kullanıcı istediği ürünü arama kutusunda aratabilmelidir.";
    private final String raporMesaji = "Aranan ürün sonuçlarda görülmüştür.";



    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase01() {

        P01_HomePage p01HomePage = new P01_HomePage();
        ReusableMethods reusableMethods =new ReusableMethods();

        //1	Web sitesine git ve Log in ol
        p01HomePage.performLogin();
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	Ürün Ara
        String aranacakUrun = "pen";
        ReusableMethods.wait(7);
        p01HomePage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.wait(5);
        ExtentReportUtil.extentTestInfo("Ürün Arandı");

        //3 Bulunan sonuçlardan istenen ürünün göründüğünü doğrula
        List<WebElement> urunListesi = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));
        boolean expectedData = true;

        if (!urunListesi.isEmpty()) {
            for (WebElement w : urunListesi) {
                if (w.getText().contains(aranacakUrun)) {
                    expectedData = true;
                    break;
                } else {
                    expectedData = false;
                }
            }
        }
        Assert.assertTrue(expectedData);
        ExtentReportUtil.extentTestInfo("Aranan Ürün Sonuçlarda Görüldü");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}
