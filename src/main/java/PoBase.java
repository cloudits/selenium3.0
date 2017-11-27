import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class PoBase {
    public static String url;
    public WebDriver wd;
    public static int timeout=10;
    public PoBase(WebDriver driver)
    {
        this.wd=driver;
    }

    public WebElement findelement(By by,int timeout)
    {
        WebElement element=null;
        try {
            element = new WebDriverWait(wd, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
        }
            catch(Exception e)
        {
            System.out.println(" | "+by.toString()+" | 对象访问失败");
            common.scrshot(wd);
        }
        finally {
            return(element);
        }
    }
    public WebElement findelement(By by)
    {
        WebElement element=null;
        try {
            element = new WebDriverWait(wd, 10).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch(Exception e)
        {
            System.out.println(" | "+by.toString()+" | 对象访问失败");
            common.scrshot(wd);
        }
        finally {
            return(element);
        }
    }
}
