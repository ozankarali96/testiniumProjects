package Pages;

import Base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static Constants.Constants.*;

public class homepage extends BasePage {
    private static Logger logger = (Logger) LogManager.getLogger(homepage.class);
    public homepage(WebDriver driver) {
        super(driver);
    }

    public homepage goToGittiGidiyor() {
        goUrl(URLGITTIGIDIYOR);
        return this;
    }

    public homepage searchProduct() throws InterruptedException {

        click(CLOSE_POPUP);
        logger.info("Pop-up kapatıldı");
        click(SEARCH_BUTTON);
        sendKeys(SEARCH_BUTTON,PRODUCT_NAME);
        click(SUBMIT_BUTTON);
        logger.info(PRODUCT_NAME + " ürünü aratıldı");
        scrollToElement(NEXTPAGE);
        Thread.sleep(1000);
        click(NEXTPAGE);
        logger.info("ikinci sayfaya geçildi");
        Thread.sleep(3000);
        Assert.assertEquals(currentUrl(),"https://www.gittigidiyor.com/arama?k=Bilgisayar&sf=2");
        logger.info("2. sayfaya geçiş doğrulandı");
        return this;
    }

   public homepage randomProductSelect() {
        List<WebElement> links = listElements(PRODUCT_LIST);
        int number = new Random().nextInt(links.size());
        links.get(number).click();
       logger.info("Rastgele ürün seçildi");
        return this;
    }
    public homepage namePriceControl() throws InterruptedException, IOException {
        String productPrice = findElement(PRODUCT_PRICE).getText();
        System.out.println(productPrice);
        String productName = findElement(PRODUCT_KNOWLEDGE).getText();
        System.out.println(productName);
        writeTxt(PRODUCT_PRICE,PRODUCT_KNOWLEDGE);
        Thread.sleep(3000);
        scrollToElement(ADD_TO_BASKET);
        Thread.sleep(1000);
        click(ADD_TO_BASKET);
        logger.info(PRODUCT_KNOWLEDGE + " ürünü sepete eklendi");
        Thread.sleep(3000);
         click(GO_TO_BASKET);
        logger.info("Sepet görüntülendi");
         String productBasketPrice = findElement(PRODUCT_BASKET_PRICE).getText();
        System.out.println("Sepetteki değeri"+ productBasketPrice );
         Assert.assertEquals(productBasketPrice, productPrice);
        logger.info("Sepetteki ürün ile ürün detay sayfasındaki ürünün doğruluğu karşılaştırıldı");
         return this;
    }
    public homepage basketThings() throws InterruptedException {
        click(AMOUNT_LIST_BOX);
        click(AMOUNT_LIST_BOX2);
        logger.info("Ürün adedi 2'ye çıkarıldı");
        Thread.sleep(1000);
        String doublePrice = findElement(DOUBLEPRICE).getText();
        System.out.println(doublePrice);
        Assert.assertEquals(doublePrice, "Sepet Tutarı (2 Adet)");

        return this;

    }
    public homepage deleteProduct() throws InterruptedException {
        click(DELETE_PRODUCT);
        logger.info("Sepetteki ürün silindi");
        Thread.sleep(1000);
        Assert.assertTrue(findElement(DELETE_PRODUCT_CONTROL).isDisplayed());
        logger.info("Sepetin boş olduğu doğrulandı.");
        return this;
    }
}