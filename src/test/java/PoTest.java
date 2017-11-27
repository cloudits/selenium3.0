import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class PoTest {
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
    }
    @Test
    public void potest1()
    {
        driver.get("http://www.baidu.com");
        PoBasic pb=new PoBasic(driver);
        pb.search("TestOps");
    }
    @Test
    public void potest2()
    {
        BaiduPo bp=new BaiduPo(driver);
        bp.search("TestOps");
        BaiduPo bp1=new BaiduPo(driver,"http://testops.ke.qq.com");
        bp1.search("testops");

    }
}
