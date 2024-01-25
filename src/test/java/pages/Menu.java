package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Menu {
    private  WebDriver driver;
    private WebDriverWait webDriverWait;

    private final By products = By.xpath("//li[@class='mm_products']//a[@class='dropmenu']");
    private  final By listproduct = By.className("submenu");
    public Menu(WebDriver driver) {
        this.driver = driver;
    }
    public void clickproduct() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(products).click();
    }
    public void clickListproduct() throws InterruptedException {
        driver.findElement(listproduct).click();
        Thread.sleep(2000);
    }
    public void clickLemo(){
        WebElement lemon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Lemon']")));
        lemon.click();
    }
    public void clickPrintBC () throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"products_print_barcodes\"]/a"));
    }
    public  void addsale() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("sales_add")).click();
    }
    public  void sales(){
        driver.findElement(By.xpath("//li[contains(@class,'mm_sales')]//a[@class='dropmenu']")).click();
    }
    public void purchases() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[contains(text(),' Purchases ')])[1]/..")).click();
    }
    public void lispurchases() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='List Purchases']")).click();
    }
    public void addpurchase() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("purchases_add")).click();
    }
}
