package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ILCP {
    private final   WebDriver driver;
    private WebDriverWait webDriverWait;
    public ILCP(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDropdown() {
    driver.findElement(By.id("dropdown")).click();
    }
// ILCP_Internal_Dashboard
    public void clickILCP_Internal ()   {
        driver.findElement(By.xpath("//button[@tabindex=\"-1\"]")).click();
    }
    //Check Facility
    public  void Albany()   {
            driver.findElement(By.xpath("//div[@aria-rowindex=\"2\"]"));
            System.out.println("Albany");
    }
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
