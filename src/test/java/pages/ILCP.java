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
    public void clickILCP_Internal ()   {
        driver.findElement(By.xpath("//button[@tabindex=\"-1\"]")).click();
    }
    //Check Facility

}
