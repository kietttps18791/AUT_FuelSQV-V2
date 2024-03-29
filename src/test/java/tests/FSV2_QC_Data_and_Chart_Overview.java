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
import pages.QC_Data_and_Charts_Overview;

import javax.swing.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static config.Config.AppConfig.PASSWORD;
import static config.Config.AppConfig.USERNAME;

public class FSV2_QC_Data_and_Chart_Overview {
    private WebDriver driver;
    WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private Dashboard dashboard;
    private QC_Data_and_Charts_Overview qc_data_and_charts_overview;

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
    public void goto_QC_DataAnd_Charts_Overview() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        qc_data_and_charts_overview = new QC_Data_and_Charts_Overview(driver,webDriverWait);
        driver.get(Config.AppConfig.BASE_URL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nav-link\"]"))).click();
        loginPage.login(USERNAME, PASSWORD);
        Thread.sleep(3000);
        dashboard.clickDropdown();
        qc_data_and_charts_overview.clickQCDataandCharts();
        Thread.sleep(2000);
        qc_data_and_charts_overview.selectLocation();
        qc_data_and_charts_overview.selectMethod();
        qc_data_and_charts_overview.selectSampleName();
        qc_data_and_charts_overview.selectInstrument();
        qc_data_and_charts_overview.selectParameter();
        qc_data_and_charts_overview.getTotal();
//        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section[1]/div/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[6]/div[2]/div")));
//        System.out.println("Total = " + getTotal.getAttribute("textContent"));
        driver.quit();
    }
}
