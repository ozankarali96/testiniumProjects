package Constants;

import org.openqa.selenium.By;

public class Constants {
    public static final String URLGITTIGIDIYOR = "https://www.gittigidiyor.com";
    public static final By SEARCH_BUTTON = By.xpath("//input[@type='text']");
    public static final String PRODUCT_NAME = "Bilgisayar";
    public static final By SUBMIT_BUTTON = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']");
    public static final By NEXTPAGE = By.xpath("(//a[@role='button'])[2]");
    public static final By PRODUCT_LIST = By.xpath("//img[@data-testid='productImage']");
    public static final By PRODUCT_PRICE = By.xpath("(//div[@id='sp-price-lowPrice'])[1]");
    public static final By PRODUCT_KNOWLEDGE = By.xpath("//h1[@id='sp-title']");
    public static final By GO_TO_BASKET = By.xpath("(//a[@href='https://www.gittigidiyor.com/sepetim'])[1]");
    public static final By PRODUCT_BASKET_PRICE = By.xpath("//p[@class='new-price']");
    public static final By AMOUNT_LIST_BOX = By.xpath("//select[@class='amount']");
    public static final By AMOUNT_LIST_BOX2 = By.xpath("//option [@value='2']");
    public static final By DELETE_PRODUCT = By.xpath("(//i[@class='gg-icon gg-icon-bin-medium'])[1]");
    public static final By DELETE_PRODUCT_CONTROL = By.xpath("//h2[text()='Sepetinizde ürün bulunmamaktadır.']");
    public static final By ADD_TO_BASKET = By.id("add-to-basket");
    public static final By CLOSE_POPUP = By.xpath("//a[@class='tyj39b-5 lfsBU']");
    public static final By DOUBLEPRICE = By.xpath("//div[@class='gg-d-16 gg-m-14 detail-text']");


}
