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

public class TC08_AddSales {
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
    public void testTC08() throws InterruptedException {
        loginPage = new LoginPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        menu = new Menu(driver);
        driver.get(Config.AppConfig.BASE_URL);
//        loginPage.clearformlogin();
        loginPage.login(Config.AppConfig.USERNAME, Config.AppConfig.PASSWORD);
        menu.sales();
        menu.addsale();
        WebElement referenceNo = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"slref\"]")));
        referenceNo.sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"s2id_slcustomer\"]")).click();
        Thread.sleep(2000);
        WebElement s2id_autogen12_search = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s2id_autogen12_search\"]")));
        s2id_autogen12_search.sendKeys("Walk-in Customer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"select2-results-12\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add_item\"]")).sendKeys("FFR01 - Grapefruit ");
        Thread.sleep(2000);
        WebElement submitSales = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_sale")));
        submitSales.submit();
        driver.quit();
    }
}

