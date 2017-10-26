import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

/**
 * Created by cloudchen on 2017-10-07.
 */
public class ExtendObj {
    public static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        driver=new FirefoxDriver();
       // driver.navigate().to("http://testops.ke.qq.com/");
       // System.out.println(driver.findElement(By.cssSelector(".mod-tab__li:nth-child(4) a")).getText());
       // System.out.println(driver.findElement(By.xpath("//div[@class=\"treeres-num js-item-num\"]")).getText());



        //   driver.navigate().to("http://127.0.0.1/selenium3/alerthtml.html");
       // alertopt();
       // promptopt();
       // iframeopt();
        newwindow();
    }
    public static void newwindow()
    {
        driver.navigate().to("http://localhost/selenium3/alerthtml.html");
        driver.findElement(By.xpath("//a")).click();
        String handle=driver.getWindowHandle();//获取当前句柄
        Set<String> handles=driver.getWindowHandles();//获取句柄集
       // System.out.println(handles.size());
        //System.out.println(handle);
        handles.remove(handle);
        driver.switchTo().window(handles.iterator().next());
        System.out.println(driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td")).getText());
    }
    public static void iframeopt()
    {
        driver.navigate().to("http://127.0.0.1/selenium3/iframe.html");
        driver.switchTo().frame("sidebar");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
        driver.switchTo().defaultContent();

    }
    public static void promptopt()
    {
        driver.findElement(By.xpath("//button[3]")).click();
        Alert alert=driver.switchTo().alert();//切换到弹出alert框上
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.sendKeys("TestOps.cn");
        alert.accept();//确认
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
