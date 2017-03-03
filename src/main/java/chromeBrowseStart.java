import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by cloudchen on 2017-02-18.
 */
public class chromeBrowseStart {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
    }
}
