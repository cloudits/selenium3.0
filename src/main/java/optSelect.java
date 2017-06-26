import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by cloudchen on 2017-06-23.
 */
public class optSelect {
    static WebDriver driver;
    public static void optlink()
    {
        driver.get("http://localhost/selenium3/xpath1.html");
        WebElement element;
        element=driver.findElement(By.xpath("/html/body/div/a"));//访问超链接
        element.click();//点击超链接
    }
    public static void optinput()
    {
        driver.get("http://localhost/selenium3/xpath2.html");
        WebElement element;
        element=driver.findElement(By.xpath("//input"));//访问input文本框
        element.sendKeys("cloud");//输入内容
        element.clear();//清空文本框
        element=driver.findElement(By.xpath("//input[2]"));//访问input文本框
        element.sendKeys("cloud");//输入内容
    }
    public static void optbutton()
    {
        driver.get("http://localhost/selenium3/xpath2.html");
        WebElement element;
        element=driver.findElement(By.xpath("//input[3]"));//访问input按钮
        element.click();
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        driver=new FirefoxDriver();
      //  optSelect.optlink();//访问超链接对象
       // optSelect.optinput();//访问文本框
        optSelect.optbutton();//访问按钮


    }
}
