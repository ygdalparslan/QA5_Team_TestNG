package tests.us07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P07_CompareProductsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportUtil;
import utilities.ReusableMethods;

public class TC04 {

    private final String testName = "US07 || TC04-Kullanıcı karşılaştıracağı ürünleri silip yeni ürünleri ekleyebilmeli";
    private final String description = "Kullanıcı karşılaştıracağı ürünleri silip yeni ürünleri ekleyebilmelidir.";
    private final String raporMesaji = "Kullanıcı karşılaştıracağı ürünleri silip yeni ürünler ekleyebilmiştir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase04() {

        P01_HomePage p01HomePage = new P01_HomePage();
        P07_CompareProductsPage p07CompareProductsPage =new P07_CompareProductsPage();
        Actions actions = new Actions(Driver.driver);

        //1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi");

        //2	Karşılaştırma yapmak için kategori seç
        p01HomePage.electronicsKategori.click();
        ExtentReportUtil.extentTestInfo("Karşılaştırma yapmak için kategori seçildi");

        //3 Seçilen Kategoriden birinci ürünün "Compare" butonuna tikla
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[1]"))).perform();
        p07CompareProductsPage.birinciUrun.click();
        ExtentReportUtil.extentTestInfo("Birinci ürün seçildi");

        //4 Seçilen Kategoriden ikinci ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[2]"))).perform();
        p07CompareProductsPage.urunEkle.click();
        ExtentReportUtil.extentTestInfo("İkinci ürün seçildi");

        //5 Karşılaştırmak için seçilen ürünlerin tamamını silmek için 'Clean All' butonuna tikla
        p07CompareProductsPage.cleanCompareButton.sendKeys(Keys.ENTER);
        Driver.getDriver().navigate().refresh();
        ExtentReportUtil.extentTestInfo("'Clean All' butonuna tıklandı");

        //6 Seçilen Kategoriden ikinci ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[3]"))).perform();
        p07CompareProductsPage.yeniUrunEkle.click();
        ExtentReportUtil.extentTestInfo("Yeni bir ürün seçildi");

        //7 Seçilen Kategoriden ikinci ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.wait(5);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[4]"))).perform();
        p07CompareProductsPage.yeniIkinciUrunEkle.click();
        ExtentReportUtil.extentTestInfo("Yeni bir ürün daha seçildi");

//        //8 'Start Compare' butonuna tıkla
//        p07CompareProductsPage.startCompareButton.sendKeys(Keys.ENTER);
//        ExtentReportUtil.extentTestInfo("'Start Compare' butonuna tıklandı");
//
//        //9 Compare için seçilen ürünlerin listelendiğini doğrula
//        int expectedResult = 5; // 5 adet ürün kıyaslandığı için 5 girildi
//        int actualResult = p07CompareProductsPage.compareList.size();
//        Assert.assertFalse(expectedResult==actualResult);
//        ExtentReportUtil.extentTestInfo("Seçilen ürünlerden en fazla 4 adedinin listelendiğini doğrulandı");
//
//        ReusableMethods.wait(5);
//        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
