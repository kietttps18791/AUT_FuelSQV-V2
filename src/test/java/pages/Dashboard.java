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
    }

}
