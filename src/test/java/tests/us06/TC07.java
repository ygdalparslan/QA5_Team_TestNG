package tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P06_ShoppingPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC07 {

    private final String testName = "US06 || TC07-Kullanıcı siteden alışveris yapabilmeli";
    private final String description = "Tüm alanlara valid veri girilmeli";
    private final String raporMesaji = "Thank you. Your order has been received. Yazısı görülüp Alışveriş tamamlanmalı";

    @Test
    public void testCase07(){

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
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.cartButton,10);
        p06ShoppingPage.cartButton.click();

        //5 "View Cart" Butonuna Tıkla
        p06ShoppingPage.viewCartButton.click();

        //6	Proceed To Checkout Butonuna Tıkla
        ReusableMethods.waitForElementToBeClickable(p06ShoppingPage.proceedToCheckoutButton,10);
        p06ShoppingPage.proceedToCheckoutButton.sendKeys(Keys.ENTER);

        //7 "Payment Methods" kısmından ödeme seçeneğini tıkla
        p06ShoppingPage.paymentMethodsWireTransfer.sendKeys(Keys.ENTER);

        //8 "Place Order" Butonuna Tıkla
        p06ShoppingPage.placeOrderButton.sendKeys(Keys.ENTER);

        //9 "Thank you. Your order has been received." doğrulanır
        String expectedData ="Thank you. Your order has been received.";
        ReusableMethods.verifyData(p06ShoppingPage.verfyOrderReceived,expectedData);

        Driver.closeDriver();

    }
}
