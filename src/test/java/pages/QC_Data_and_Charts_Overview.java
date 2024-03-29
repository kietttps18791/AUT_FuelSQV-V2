package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QC_Data_and_Charts_Overview {
    private final   WebDriver driver;
    //    WebDriverWait webDriverWait = new WebDriverWait(driver,30);
     WebDriverWait webDriverWait;
    //    private  final By dropdown = By.id("dropdown");

    public QC_Data_and_Charts_Overview(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;

    }


    public void clickQCDataandCharts(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"dropdown-item\"][1]"))).click();
    }
    public void selectLocation(){
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement selectLoction = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));// Change location in ""
        Select select = new Select(driver.findElement(By.id("location")));
        select.selectByValue("America - East Coast - Philadelphia");
    }
    public void selectMethod(){
        Select select = new Select( driver.findElement(By.id("method")));
        select.selectByValue("D5191");// Change method in ""
    }
    public void selectSampleName(){
        Select select = new Select( driver.findElement(By.id("sampleName")));
        select.selectByValue("Gasoline QC 10");// Change sampleName in ""
         }
    public void selectInstrument(){
        Select select = new Select( driver.findElement(By.id("instrument")));
        select.selectByValue("Demo3");// Change instrument in ""
    }
    public void selectParameter(){
        Select select = new Select( driver.findElement(By.id("parameter")));
        select.selectByValue("DVPE");// Change parameter in ""
    }
    public void getTotal(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section[1]/div/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[6]/div[2]/div")));
        System.out.println("Total = " + getTotal.getAttribute("textContent"));
//        driver.findElements(By.xpath("//div[@title='22']"));
    }





}
