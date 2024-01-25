package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverManager.getDriver;

public class LoginPage {
    private final WebDriver driver;
    private WebDriverWait webDriverWait;

    private final  By emailInput = By.xpath("//input[@name='email']");
    private final By passwordInput = By.xpath("//input[@name='pass']");
    private final By loginButton = By.xpath("//button[@class='btn btn-primary btn-lg']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String getSucces() {
        return driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
    }

    public void login(String username, String password){
        driver.findElement(emailInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();}

}