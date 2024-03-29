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
        select.selectByValue("D3606");// Change method in ""
    }
    public void selectSampleName(){
        Select select = new Select( driver.findElement(By.id("sampleName")));
        select.selectByValue("Gasoline QC 4");// Change sampleName in ""
         }
    public void selectInstrument(){
        Select select = new Select( driver.findElement(By.id("instrument")));
        select.selectByValue("4026");// Change instrument in ""
    }
    public void selectParameter(){
        Select select = new Select( driver.findElement(By.id("parameter")));
        select.selectByValue("Benzene");// Change parameter in ""
    }
    public void getTotal(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section[1]/div/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[6]/div[2]/div")));
        System.out.println("Total = " + getTotal.getAttribute("textContent"));
    }
    public void getParameter(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/section[@class='SectionComponent py-1 position-relative bg-white text-dark']/div[contains(@class,'container py-md-1 container my-md-1')]/div[@class='chart-section-container']/div[@class='row']/div[@class='chart-section-overall-container']/div[@class='charts-master-container']/div/div[@class='statistics-table']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")));
        System.out.println("Parameter = " + getTotal.getAttribute("textContent"));
    }
    public void getAverage(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='charts-master-container']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")));
        System.out.println("Average = " + getTotal.getAttribute("textContent"));
    }
    public void getStd_RMS(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='charts-master-container']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[2]")));
        System.out.println("Standard Deviation, RMS = " + getTotal.getAttribute("textContent"));
    }
    public void getStd_MR(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='charts-master-container']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[3]//div[2]")));
        System.out.println("Standard Deviation, MR = " + getTotal.getAttribute("textContent"));
    }
    public void getRepeatability(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='charts-master-container']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[4]//div[2]")));
        System.out.println("Repeatability = " + getTotal.getAttribute("textContent"));
    }
    public void getUCL(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='charts-master-container']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[5]//div[2]")));
        System.out.println("UCL = " + getTotal.getAttribute("textContent"));
    }
    public void getReproducibility(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")));
        System.out.println("getReproducibility = " + getTotal.getAttribute("textContent"));
    }
    public void getPrecisionRatio(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[2]")));
        System.out.println("Reproducibility = " + getTotal.getAttribute("textContent"));
    }
    public void getTPI(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[3]//div[2]")));
        System.out.println("TPI = " + getTotal.getAttribute("textContent"));
    }
    public void getAndersonDarling(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[4]//div[2]")));
        System.out.println("Anderson Darling = " + getTotal.getAttribute("textContent"));
    }
    public void getLCL(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[5]//div[2]")));
        System.out.println("LCL = " + getTotal.getAttribute("textContent"));
    }
    public void getSitePrecision(){
        WebElement getTotal = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='statistics-table']//div[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[6]//div[2]")));
        System.out.println("Site Precision = " + getTotal.getAttribute("textContent"));
    }





}
