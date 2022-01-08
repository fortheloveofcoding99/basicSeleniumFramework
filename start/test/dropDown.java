import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class dropDown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/befor/New folder/chromedriver.exe ");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/dropdown");
        WebElement dd = driver.findElement(By.id("dropdownMenuButton"));
        dd.click();
        dd.findElement(By.xpath("/html/body/div/div/div/a[2]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
