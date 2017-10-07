import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by cloudchen on 2017-10-07.
 */
public class ExtendObj {
    public static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        driver=new FirefoxDriver();
        driver.navigate().to("http://127.0.0.1/selenium3/alerthtml.html");
        alertopt();
    }
    public static void alertopt()
    {
        driver.findElement(By.xpath("//button")).click();
        Alert alert=driver.switchTo().alert();//切换到弹出alert框上
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.accept();//确认
        //alert.dismiss();//拒绝
    }
}
