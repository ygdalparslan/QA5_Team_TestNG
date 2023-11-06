package tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TC06 {

    private final String testName = "US06 || TC06-Ödeme seçenekleri seçilebilmeli";
    private final String description = "Kullanıcı Ödeme seçeneklerinden istediğini seçebilmelidir.";
    private final String raporMesaji = "İstenen Ödeme yöntemi seçilmiştir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testCase06() {

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

        //6	Proceed To Checkout Butonuna Tıkla
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.proceedToCheckoutButton, 10);
        p06ShoppingPage.proceedToCheckoutButton.sendKeys(Keys.ENTER);
        ExtentReportUtil.extentTestInfo("Proceed To Checkout Butonuna Tıklandı");

        //7 "Payment Methods" kısmından "Pay at the door" seçeneğini tıkla
        boolean beforeClickPayAtTheDoor = p06ShoppingPage.paymentMethodsPayAtTheDoor.isSelected();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", p06ShoppingPage.paymentMethodsPayAtTheDoor);
        boolean afterClickPayAtTheDoor = p06ShoppingPage.paymentMethodsPayAtTheDoor.isSelected();
        ExtentReportUtil.extentTestInfo("Pay At The Door Yöntemi Seçildi");

        //8 "Payment Methods" kısmından "Wire transfer/EFT" seçeneğini tıkla
        ReusableMethods.wait(5);
        boolean beforeClickWireTransfer = p06ShoppingPage.paymentMethodsWireTransfer.isSelected();
        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", p06ShoppingPage.paymentMethodsWireTransfer);
        boolean afterClickWireTransfer = p06ShoppingPage.paymentMethodsWireTransfer.isSelected();
        ExtentReportUtil.extentTestInfo("Wire transfer/EFT Yöntemi Seçildi");

        //9 İstenen Ödeme yönteminin seçildiğini doğrula
        ReusableMethods.wait(5);
        boolean expectedDate = (beforeClickPayAtTheDoor != afterClickPayAtTheDoor) && (beforeClickWireTransfer != afterClickWireTransfer);
        Assert.assertTrue(expectedDate);
        ExtentReportUtil.extentTestInfo("İstenen Ödeme Yönteminin Seçildiği Doğrulandı");

        ReusableMethods.wait(5);
        Driver.closeDriver();
        ExtentReportUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
