import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by cloudchen on 2017-03-03.
 */
public class fireFoxBrowseStart {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.baidu.com");
    }
}
