import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class switchToActiveWindow {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/befor/New folder/chromedriver.exe ");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        driver.findElement(By.id("new-tab-button")).click();
        Set <String> windows = driver.getWindowHandles();
        Iterator <String> it = windows.iterator();
        String parentId = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
        Thread.sleep(1000);
        driver.switchTo().window(parentId);
        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.id("alert-button"));
        alert.click();
        Alert alrt = driver.switchTo().alert();
        String txt = alrt.getText();
        System.out.println(txt);
        alrt.accept();
        Thread.sleep(1000);
        driver.quit();
    }
}