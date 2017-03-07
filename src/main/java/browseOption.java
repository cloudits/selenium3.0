import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by cloudchen on 2017-03-07.
 */
public class browseOption {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        //打开某个网页，http不可少
        driver.get("http://www.baidu.com");

        //打开某个网页，等同于上面的get方法
        //driver.navigate().to("http://www.google.com");

        //浏览器后退
        //driver.navigate().back();

        //浏览器前进
        //driver.navigate().forward();

        //浏览器刷新
        driver.navigate().refresh();

        //浏览器最大化
        driver.manage().window().maximize();

        //设置浏览器大小
        Dimension dimension = new Dimension(900, 800);
        driver.manage().window().setSize(dimension);
        //获取当前页面URL
        System.out.println(driver.getCurrentUrl());
        //获取当前页面Title
        System.out.println(driver.getTitle());

        //关闭当前窗口
        driver.close();

        //关闭所有窗口并退出
        driver.quit();
    }
}
