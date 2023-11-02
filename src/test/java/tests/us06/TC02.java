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
import utilities.ReusableMethods;

import java.util.List;

public class TC02 {

    private final String testName = "US06 || TC02-Kullanıcı aradağı ürünü sepete ekleyebilmeli";
    private final String description = "Aranan ürün sonuçlarda görünmeli";
    private final String raporMesaji = "Aranan ürün sepete eklenmiştir";

    @Test
    public void testCase02(){

        P01_HomePage p01HomePage =new P01_HomePage();
        P06_ShoppingPage p06ShoppingPage =new P06_ShoppingPage();
        Actions actions =new Actions(Driver.driver);

        //1	Web sitesine gidilir.
        //2	Log in olunur.
        ReusableMethods.performLogin();

        //3	Search box  kısmına aranacak ürün ismi yazılır ve aratılır.
        String aranacakUrun ="pen";
        ReusableMethods.wait(7);
        p01HomePage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.wait(5);

        //4 Bulunan sonuçlardan istenen ürün üzerine gelinerek sepet simgesine (Cart) tıklanır.
        List<WebElement> urunListesi = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));


        if (urunListesi.size() >= 2) {
            WebElement ikinciUrun = urunListesi.get(1);
            actions.moveToElement(ikinciUrun).perform();
        } else {
            System.out.println("Listede en az iki ürün bulunmalıdır.");
        }


        p06ShoppingPage.addToCartButton.click();

        //5	Site sayfasından sağ üst sekmede yer alan sepet simgesine (Cart) tıklanır.
        p06ShoppingPage.cartButton.click();

        //6 Açılan sekmede seçilen ürünün olduğu doğrulanır.
        Assert.assertTrue(p06ShoppingPage.viewCartButton.isDisplayed());

        Driver.closeDriver();

    }
}
