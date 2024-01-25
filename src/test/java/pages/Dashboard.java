package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private final   WebDriver driver;
//    WebDriverWait webDriverWait = new WebDriverWait(driver,30);
    private WebDriverWait webDriverWait;
//    private  final By dropdown = By.id("dropdown");
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDropdown() {
    driver.findElement(By.id("dropdown")).click();
    }
    public void clickILCP(){
        driver.findElement(By.xpath("//a[@class=\"dropdown-item\"][4]")).click();
//        WebElement ILCP = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"dropdown-item\"][4]")));
//        ILCP.click();
    }
    public void clickILCP_Internal ()   {
        driver.findElement(By.xpath("//button[@tabindex=\"-1\"]")).click();
//        WebElement ILCP_Internal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@tabindex=\"-1\"]")));
//        ILCP_Internal.click();
    }
//    public  void addsale() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.id("sales_add")).click();
//    }
//    public  void sales(){
//        driver.findElement(By.xpath("//li[contains(@class,'mm_sales')]//a[@class='dropmenu']")).click();
//    }
//    public void purchases() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//span[contains(text(),' Purchases ')])[1]/..")).click();
//    }
//    public void lispurchases() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//span[normalize-space()='List Purchases']")).click();
//    }
//    public void addpurchase() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.id("purchases_add")).click();
//    }
}
