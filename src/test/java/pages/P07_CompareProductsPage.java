package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class P07_CompareProductsPage {

    public P07_CompareProductsPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[aria-label='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//li/a[text()='Electronics']")
    public WebElement electronicsKategori;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement birinciUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[2]")
    public WebElement urunEkle;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[3]")
    public WebElement yeniUrunEkle;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[3]")
    public WebElement yeniIkinciUrunEkle;

    @FindBy(xpath = "//a[.='Start Compare !']")
    public WebElement startCompareButton;

    @FindBy(xpath = "//div[@class='compare-basic-info']")
    public List<WebElement> compareList;

    @FindBy(xpath = "//a[@class='compare-clean']")
    public WebElement cleanCompareButton;
}
