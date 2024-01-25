package tests;

//import config.AppConfig;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import pages.Menu;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TC10_AddPurchases {
    private WebDriver driver;
    WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private BasePage basePage;
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
    public void testTC10() throws InterruptedException {
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        menu = new Menu(driver);
        driver.get(Config.AppConfig.BASE_URL);
//        loginPage.clearformlogin();
        loginPage.login(Config.AppConfig.USERNAME, Config.AppConfig.PASSWORD);
        menu.purchases();
        menu.addpurchase();
        WebElement poref = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"poref\"]")));
        poref.sendKeys("test");
        Thread.sleep(2000);
        WebElement select2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-chosen-8\"]")));
        select2.click();
        WebElement s2id_autogen8_search = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s2id_autogen8_search\"]")));
        s2id_autogen8_search.sendKeys("IT Hyperzone");
        s2id_autogen8_search.sendKeys(Keys.ENTER);
        WebElement add_item = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_item")));
        add_item.sendKeys("FFR01 - Grapefruit ");
        add_item.sendKeys(Keys.ENTER);
        WebElement add_pruchase = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_pruchase")));
        add_pruchase.submit();
        driver.quit();
    }
}

