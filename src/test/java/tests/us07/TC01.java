package tests.us07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportUtil;
import utilities.ReusableMethods;

import java.util.List;

public class TC01 {

    private final String testName = "US07 || TC01-Kullanıcı seçtiği ürünleri karşılaştırabilmeli";
    private final String description = "Kullanıcı seçtiği ürünleri karşılaştırabilmelidir.";
    private final String raporMesaji = "Kullanıcı seçtiği ürünleri karşılaştırabilmiştir.";


    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase01() {

        P01_HomePage p01HomePage = new P01_HomePage();
        Actions actions = new Actions(Driver.driver);
        ReusableMethods reusableMethods = new ReusableMethods();

        //1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi");

        //2	Karşılaştırma yapmak için kategöri seç
        p01HomePage.electronicsKategori.click();

        //3 Seçilen Kategoriden birinci ürünün "Compare" butonuna tikla
        List<WebElement> urunListesi = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));
        if (urunListesi.size() > 2) {
            WebElement birinciUrun = urunListesi.get(0);
            actions.moveToElement(birinciUrun).perform();
        } else {
            System.out.println("Listede en az iki ürün bulunmalıdır.");
            return; // Eğer yeterli ürün yoksa testi burada sonlandır
        }
        p01HomePage.birinciUrun.click();
        ExtentReportUtil.extentTestInfo("Birinci ürün seçildi");

        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(5);

        //4 Seçilen Kategoriden ikinci ürünün "Compare" butonuna tikla
        List<WebElement> urunListesi2 = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));
        if (urunListesi2.size() > 2) {
            WebElement ikinciUrun = urunListesi2.get(1);
            actions.moveToElement(ikinciUrun).perform();
        } else {
            System.out.println("Listede en az iki ürün bulunmalıdır.");
            return; // Eğer yeterli ürün yoksa testi burada sonlandır
        }
        p01HomePage.ikinciUrun.click();
        ExtentReportUtil.extentTestInfo("İkinci ürün seçildi");

        //5 'Start Compare' butonuna tıkla
        p01HomePage.startCompareButton.sendKeys(Keys.ENTER);
        ExtentReportUtil.extentTestInfo("'Start Compare' butonuna tıklandı");

        //6 Compare için seçilen ürünlerin listelendiğini doğrula
        int expectedResult  =2; // 2 adet ürün kıyaslandığı için 2 girildi
        int actualResult = p01HomePage.compareList.size();
        Assert.assertEquals(expectedResult,actualResult);
        ExtentReportUtil.extentTestInfo("Seçilen ürünlerin listelendiğini doğrulandı");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
