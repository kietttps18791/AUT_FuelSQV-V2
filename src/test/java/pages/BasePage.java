package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public  WebDriver getDriver(){
        return driver;
    }
    public  WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }
}
