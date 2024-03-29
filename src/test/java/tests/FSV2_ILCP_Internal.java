package tests;

//import config.AppConfig;
import config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Dashboard;
import pages.ILCP;
import pages.LoginPage;

import javax.swing.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static config.Config.AppConfig.PASSWORD;
import static config.Config.AppConfig.USERNAME;

public class FSV2_ILCP_Internal {
    private WebDriver driver;
    WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private Dashboard dashboard;
    private ILCP ilcp;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws MalformedURLException {
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setCapability("platformName", "Windows");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
    }

    //    @AfterClass
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
    @Test(priority = 1)
    public void gotoInternal_Dashboard() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        ilcp = new ILCP(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get(Config.AppConfig.BASE_URL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nav-link\"]"))).click();
        loginPage.login(USERNAME, PASSWORD);
        Thread.sleep(3000);
        dashboard.clickDropdown();
        dashboard.clickILCP();
        ilcp.clickILCP_Internal();
        Thread.sleep(6000);

        List<WebElement> text = driver.findElements(By.className("rs-table-cell-content"));
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).getAttribute("textContent") != "") {
                System.out.println(text.get(i).getAttribute("textContent"));
            }

        }
        driver.quit();
    }
}


