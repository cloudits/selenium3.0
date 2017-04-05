import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by cloudchen on 2017-04-05.
 */
public class XpathSample {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://localhost:63342/selenium3/src/main/xpath/xpath2.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='login']/input[1]"));
        //完成了对象定位及获取，但没有操作
    }
}
