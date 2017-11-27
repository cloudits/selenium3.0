import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class PoTest {
    @Test
    public void potest1()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        PoBasic pb=new PoBasic(driver);
        pb.search("TestOps");
    }
}
