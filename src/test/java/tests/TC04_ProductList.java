package tests;

//import config.AppConfig;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.Menu;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC04_ProductList {
    private WebDriver driver;
    WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private Menu menu;
    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws MalformedURLException {
        if(browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName","Windows");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),chromeOptions);
            driver.manage().window().maximize();
        }
        if(browser.equals("firefox")){
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.setCapability("platformName","Windows");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),firefoxOptions);
            driver.manage().window().maximize();
        }

    }
    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test(priority = 1)
    public void testTC04() throws InterruptedException {
        loginPage = new LoginPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        menu = new Menu(driver);
        driver.get(Config.AppConfig.BASE_URL);
//        loginPage.clearformlogin();
        loginPage.login(Config.AppConfig.USERNAME, Config.AppConfig.PASSWORD);
        menu.clickproduct();
        menu.clickListproduct();
        WebElement lemon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Lemon']")));
        lemon.click();
        driver.quit();
    }
}

