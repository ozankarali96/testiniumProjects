package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class BasePage extends BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver,60);
    }



    public void goUrl(String url){
        driver.get(url);
    }
    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void click(By by){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();

    }
    public void sendKeys(By by,String text){
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }
    public List<WebElement> listElements(By by) {
        return driver.findElements(by);
    }
    public void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public void writeTxt(By by1,By by2)  throws IOException {
        String  productDetail = findElement(by1).getText();
        String  productPrice = findElement(by2).getText();
        FileWriter w = new FileWriter("C:\\Users\\EXT02D24061\\Desktop\\bitexenProje-main\\productDetail.txt");
        BufferedWriter out = new BufferedWriter(w);
        out.write(productDetail);
        out.write(productPrice);
        out.flush();
    }
}



