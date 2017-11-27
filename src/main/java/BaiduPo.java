import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class BaiduPo extends PoBase {
    public static By baidusearchtext=By.id("kw");
    public static By baidusearchbutton=By.id("su");
    public static String url="http://www.baidu.com";
    public BaiduPo(WebDriver wd)
    {
        super(wd);
        wd.get(this.url);
    }
    public BaiduPo(WebDriver wd,String url)
    {
        super(wd);
        wd.get(url);
    }
    public void search(String searchstring)
    {
        this.findelement(baidusearchtext).sendKeys(searchstring);
        this.findelement(baidusearchbutton,5).click();
    }
}
