import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-07-01.
 */
public class testSelenium1 {
    static WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        driver=new FirefoxDriver();
        driver.get("http://www.baidu.com");

    }

    @Test
    public void mycase1()
    {
        WebElement element_searchtext;
        element_searchtext=driver.findElement(By.xpath(".//*[@id='kw']"));//百度搜索框
        element_searchtext.sendKeys("云层");
        WebElement element_searchbutton;
        element_searchbutton=driver.findElement(By.xpath(".//*[@id='su']"));//百度搜索按钮
        element_searchbutton.click();
        try {
            Thread.sleep(3000);//线程等待3秒，不推荐用，暂时这里为了效果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element_searchresult;//由于搜索有时候要一些时间，为了避免出现由于没有刷新导致的对象访问不到，所以这里加入了线程等待
        element_searchresult=driver.findElement(By.xpath(".//*[@id='container']/div[2]/div/div[2]"));//搜索结果匹配记录的区域定位
        System.out.println(element_searchresult.getText());//输出搜索结果
        Assert.assertNotNull(element_searchtext,"不存在搜索结果");

    }
    @Test
    public void mycase2()
    {
        WebElement element_searchtext;
        element_searchtext=driver.findElement(By.xpath(".//*[@id='kw']"));//百度搜索框
        element_searchtext.sendKeys("陈霁");
        WebElement element_searchbutton;
        element_searchbutton=driver.findElement(By.xpath(".//*[@id='su']"));//百度搜索按钮
        element_searchbutton.click();
        try {
            Thread.sleep(3000);//线程等待3秒，不推荐用，暂时这里为了效果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element_searchresult;//由于搜索有时候要一些时间，为了避免出现由于没有刷新导致的对象访问不到，所以这里加入了线程等待
        element_searchresult=driver.findElement(By.xpath(".//*[@id='container']/div[2]/div/div[2]"));//搜索结果匹配记录的区域定位
        System.out.println(element_searchresult.getText());//输出搜索结果
        Assert.assertNotNull(element_searchtext,"不存在搜索结果");

    }
}
