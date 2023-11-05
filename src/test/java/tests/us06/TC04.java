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

public class TC04 {

    private final String testName = "US06 || TC04-Sepete eklenen ürünlerin miktarı azaltılabilmeli";
    private final String description = "Kullanıcı Sepete eklediği ürünlerin miktarını azaltabilmelidir.";
    private final String raporMesaji = "Sepete eklenen ürünlerin miktarı azaltılmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase04() {

        P01_HomePage p01HomePage = new P01_HomePage();
        P06_ShoppingPage p06ShoppingPage = new P06_ShoppingPage();
        Actions actions = new Actions(Driver.driver);

        //1	Web sitesine git ve Log in ol
        ReusableMethods.wait(3);
        ReusableMethods.performLogin();
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
        actions.doubleClick(p06ShoppingPage.addToCartButton).perform();
        ExtentReportUtil.extentTestInfo("İstenen Ürün Üzerinde Sepete Tıklandı");

        //4	Sağ Üst Köşedeki Sepete (Cart) Tıkla
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.cartButton, 10);
        p06ShoppingPage.cartButton.click();
        ExtentReportUtil.extentTestInfo("Sepete Tıklandı");

        //5 "View Cart" Butonuna Tıkla
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.viewCartButton, 10);
        p06ShoppingPage.viewCartButton.click();
        ExtentReportUtil.extentTestInfo("View Cart Butonuna Tıklandı");

        //6	Sepetteki Ürün Miktarını Azalt
        int firstQuantity = Integer.parseInt(p06ShoppingPage.quantity.getAttribute("value"));
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.cartButtonDetailQuantityMinus, 10);
        p06ShoppingPage.cartButtonDetailQuantityMinus.click();
        int lastQuantity = Integer.parseInt(p06ShoppingPage.quantity.getAttribute("value"));
        ExtentReportUtil.extentTestInfo("Sepetteki Ürün Miktarı Azaltıldı");

        //7	Ürün Miktarının Azaldığını Doğrula
        boolean expecdetData = lastQuantity < firstQuantity;
        Assert.assertTrue(expecdetData);
        ExtentReportUtil.extentTestInfo("Ürün Miktarının Azaltıldığı Doğrulandı");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
