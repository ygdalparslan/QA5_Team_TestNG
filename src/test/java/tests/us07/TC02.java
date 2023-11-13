package tests.us07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportUtil;
import utilities.ReusableMethods;

public class TC02 {

    private final String testName = "US07 || TC02-Kullanıcı en fazla 4 ürünü karşılaştırmak için seçebilmeli";
    private final String description = "Kullanıcı en fazla 4 ürünü karşılaştırmak için seçebilmelidir.";
    private final String raporMesaji = "Kullanıcı en fazla 4 ürünü karşılaştırmak için seçebilmiştir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase02() {

        P01_HomePage p01HomePage = new P01_HomePage();
        Actions actions = new Actions(Driver.driver);

        //1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi");

        //2	Karşılaştırma yapmak için kategori seç
        p01HomePage.electronicsKategori.click();
        ExtentReportUtil.extentTestInfo("Karşılaştırma yapmak için kategori seçildi");

        //3 Seçilen Kategoriden birinci ürünün "Compare" butonuna tikla
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[1]"))).perform();
        p01HomePage.birinciUrun.click();
        ExtentReportUtil.extentTestInfo("Birinci ürün seçildi");

        //4 Seçilen Kategoriden ikinci ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[2]"))).perform();
        p01HomePage.ikinciUrun.click();
        ExtentReportUtil.extentTestInfo("İkinci ürün seçildi");

        //5 Seçilen Kategoriden üçüncü ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[3]"))).perform();
        p01HomePage.ucuncuUrun.click();
        ExtentReportUtil.extentTestInfo("Üçüncü ürün seçildi");

        //6 Seçilen Kategoriden dördüncü ürünün "Compare" butonuna tikla
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//li[@class='product-wrap'])[4]"))).perform();
        p01HomePage.dorduncuUrun.click();
        ExtentReportUtil.extentTestInfo("Dördüncü ürün seçildi");

        //7 'Start Compare' butonuna tıkla
        p01HomePage.startCompareButton.sendKeys(Keys.ENTER);
        ExtentReportUtil.extentTestInfo("'Start Compare' butonuna tıklandı");

        //6 Compare için seçilen ürünlerin listelendiğini doğrula
        int expectedResult = 4; // 4 adet ürün kıyaslandığı için 4 girildi
        int actualResult = p01HomePage.compareList.size();
        Assert.assertEquals(expectedResult, actualResult);
        ExtentReportUtil.extentTestInfo("Seçilen ürünlerin listelendiğini doğrulandı");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
