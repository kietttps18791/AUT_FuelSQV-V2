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

public class TC07_AddProductPrintBarCode {
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
    public void testTC07() throws InterruptedException {
        loginPage = new LoginPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        menu = new Menu(driver);
        driver.get(Config.AppConfig.BASE_URL);
//        loginPage.clearformlogin();
        loginPage.login(Config.AppConfig.USERNAME, Config.AppConfig.PASSWORD);
        menu.clickproduct();
        WebElement products_print_barcodes = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products_print_barcodes\"]/a")));
        products_print_barcodes.click();
        WebElement kiwi = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_item")));
        kiwi.sendKeys("Kiwi");
        Thread.sleep(2000);
        WebElement style = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s2id_style\"]/a")));
        style.click();
        WebElement style_18 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-results-1\"]/li[6]")));
        style_18.click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"barcode-print-form\"]/div[3]/div[4]/ins")).click();//Currencies
        driver.findElement(By.xpath("//*[@id=\"barcode-print-form\"]/div[3]/div[5]/ins")).click();//Unit
        driver.findElement(By.xpath("//*[@id=\"barcode-print-form\"]/div[3]/div[6]/ins")).click();//Category
        driver.findElement(By.xpath("//*[@id=\"barcode-print-form\"]/div[3]/div[7]/ins")).click();//Variants
        driver.findElement(By.xpath("//*[@id=\"barcode-print-form\"]/div[3]/div[8]/ins")).click();//Product Image
        WebElement update = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='print']")));
        update.submit();
        driver.quit();
    }
}

