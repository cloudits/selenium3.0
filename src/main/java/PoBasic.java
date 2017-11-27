import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class PoBasic {
    public static By baidusearchtext=By.id("kw");
    public static By baidusearchbutton=By.id("su");
    public static String url="http://www.baidu.com";
    public WebDriver wd;
    public PoBasic(WebDriver driver)
    {
        this.wd=driver;
        wd.get(url);

    }
    public void search(String searchstring)
    {
        wd.findElement(baidusearchtext).sendKeys(searchstring);
        wd.findElement(baidusearchbutton).click();
    }

}
