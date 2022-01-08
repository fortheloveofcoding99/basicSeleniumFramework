import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CompleteForm {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/befor/New folder/chromedriver.exe ");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");


        submit_form(driver);

        waitForAlert(driver);

        String expectedText = "The form was successfully submitted!";
        Assert.assertEquals(getAlert(driver), expectedText);
        driver.quit();
    }
    public static void submit_form(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("Som");
        driver.findElement(By.id("last-name")).sendKeys("Sarkar");
        driver.findElement(By.id("job-title")).sendKeys("QA");
        driver.findElement(By.cssSelector("input[value='radio-button-3']")).click();
        driver.findElement(By.id("checkbox-1")).click();
        WebElement dd = driver.findElement(By.id("select-menu"));
        Select s = new Select(dd);
        s.selectByIndex(2);
        Thread.sleep(3000);
        driver.findElement(By.id("datepicker")).sendKeys("22/04/2022");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }


    public static void waitForAlert(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
    }

    public static String getAlert(WebDriver driver){
        return driver.findElement(By.className("alert")).getText();
    }
}
