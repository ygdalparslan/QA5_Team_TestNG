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

public class TC03 {

    private final String testName = "US06 || TC03-Sepete eklenen ürünlerin miktarı artırılabilmeli";
    private final String description = "Kullanıcı Sepete eklediği ürünlerin miktarını artırabilmelidir.";
    private final String raporMesaji = "Sepete eklenen ürünlerin miktarı artırılmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase03() {

        P01_HomePage p01HomePage = new P01_HomePage();
        P06_ShoppingPage p06ShoppingPage = new P06_ShoppingPage();
        Actions actions = new Actions(Driver.driver);

        //1	Web sitesine git ve Log in ol
        p01HomePage.performLogin();
        ExtentReportUtil.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	Ürün Ara
        String aranacakUrun = "pen";
        ReusableMethods.wait(7);
        p01HomePage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.wait(5);
        ExtentReportUtil.extentTestInfo("Ürün Arandı");

        //3 Bulunan sonuçlardan istenen ürün üzerine gel ve sepete (Cart) tıkla
        List<WebElement> urunListesi = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));

        if (urunListesi.size() >= 2) {
            WebElement ikinciUrun = urunListesi.get(1);
            actions.moveToElement(ikinciUrun).perform();
        } else {
            System.out.println("Listede en az iki ürün bulunmalıdır.");
            return; // Eğer yeterli ürün yoksa testi burada sonlandır
        }
        p06ShoppingPage.addToCartButton.click();
        ExtentReportUtil.extentTestInfo("İstenen Ürün Üzerinde Sepete Tıklandı");

        //4	Sağ Üst Köşedeki Sepete (Cart) Tıkla
        p06ShoppingPage.cartButton.click();
        ExtentReportUtil.extentTestInfo("Sepete Tıklandı");

        //5 "View Cart" Butonuna Tıkla
        p06ShoppingPage.viewCartButton.click();
        ExtentReportUtil.extentTestInfo("View Cart Butonuna Tıklandı");

        //6	Sepetteki Ürün Miktarını Artır
        int firstQuantity = Integer.parseInt(p06ShoppingPage.quantity.getAttribute("value"));
        p06ShoppingPage.cartButtonDetailQuantityPlus.click();
        int lastQuantity = Integer.parseInt(p06ShoppingPage.quantity.getAttribute("value"));
        ExtentReportUtil.extentTestInfo("Sepetteki Ürün Miktarı Artırıldı");

        //7	Ürün Miktarının Arttığını Doğrula
        boolean expecdetData = lastQuantity > firstQuantity;
        Assert.assertTrue(expecdetData);
        ExtentReportUtil.extentTestInfo("Ürün Miktarının Arttığı Doğrulandı");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}
