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
import utilities.ReusableMethods;

import java.util.List;

public class TC06 {

    private final String testName = "US06 || TC06-Ödeme seçenekleri seçilebilmeli";
    private final String description = "Kullanıcı Ödeme seçeneklerinden istediğini seçebilmeli";
    private final String raporMesaji = "İstenen Ödeme yöntemi seçilmiştir.";

    @Test
    public void testCase06(){

        P01_HomePage p01HomePage =new P01_HomePage();
        P06_ShoppingPage p06ShoppingPage =new P06_ShoppingPage();
        Actions actions =new Actions(Driver.driver);

        //1	Web sitesine git ve Log in ol
        ReusableMethods.performLogin();

        //2	Ürün Ara
        String aranacakUrun ="pen";
        ReusableMethods.wait(7);
        p01HomePage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.wait(5);

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

        //4	Sağ Üst Köşedeki Sepete (Cart) Tıkla
        p06ShoppingPage.cartButton.click();

        //5 "View Cart" Butonuna Tıkla
        p06ShoppingPage.viewCartButton.click();

        //6	Proceed To Checkout Butonuna Tıkla
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.proceedToCheckoutButton,10);
        p06ShoppingPage.proceedToCheckoutButton.sendKeys(Keys.ENTER);

        //7 "Payment Methods" kısmından "Pay at the door" seçeneğini tıkla
        boolean beforeClickPayAtTheDoor=p06ShoppingPage.paymentMethodsPayAtTheDoor.isSelected();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", p06ShoppingPage.paymentMethodsPayAtTheDoor);
        boolean afterClickPayAtTheDoor=p06ShoppingPage.paymentMethodsPayAtTheDoor.isSelected();


        //8 "Payment Methods" kısmından "Wire transfer/EFT" seçeneğini tıkla
        ReusableMethods.wait(5);
        boolean beforeClickWireTransfer=p06ShoppingPage.paymentMethodsWireTransfer.isSelected();
        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", p06ShoppingPage.paymentMethodsWireTransfer);
        boolean afterClickWireTransfer=p06ShoppingPage.paymentMethodsWireTransfer.isSelected();

        //9 İstenen Ödeme yönteminin seçildiğini doğrula
        ReusableMethods.wait(5);
        boolean expectedDate=(beforeClickPayAtTheDoor!=afterClickPayAtTheDoor) && (beforeClickWireTransfer!=afterClickWireTransfer);
        Assert.assertTrue(expectedDate);

        Driver.closeDriver();

    }
}
