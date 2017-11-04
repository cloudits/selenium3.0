
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
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
       // newwindow1();
        //onmouseover();
        scrshot();
        selectobj();
    }

    public static void selectobj()
    {
        driver.navigate().to("http://127.0.0.1/selenium3/htmlbasic.html");
        WebElement element=driver.findElement(By.xpath("html/body/form/select"));
        Select select=new Select(element);
        select.selectByIndex(2);
    }

     public static void scrshot()
    {
        driver.navigate().to("http://localhost/selenium3/alerthtml.html");
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile,new File("D:/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void onmouseover()
    {
        driver.navigate().to("http://localhost/selenium3/alerthtml.html");
        Actions MyA=new Actions(driver);
        WebElement button4=driver.findElement(By.xpath("//button[4]"));
        MyA.moveToElement(button4).perform();
    }
    public static void newwindow1()
    {
        driver.navigate().to("http://localhost/selenium3/alerthtml.html");
        driver.findElement(By.xpath("//a")).click();
        String handle=driver.getWindowHandle();//获取当前句柄
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handle))
                continue;
            else
                driver.switchTo().window(handles);

        }
        System.out.println(driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td")).getText());
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
        //driver.switchTo().parentFrame();
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
