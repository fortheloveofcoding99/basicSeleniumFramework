import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class scroll {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/befor/New folder/chromedriver.exe ");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement name = driver.findElement(By.id("name"));
        Actions ac = new Actions(driver);
        ac.moveToElement(name);
        name.sendKeys("Som");
        WebElement date = driver.findElement(By.id("date"));
        ac.moveToElement(date);
        date.sendKeys("01/01/2022");
        Thread.sleep(1000);
        driver.quit();


    }
}
