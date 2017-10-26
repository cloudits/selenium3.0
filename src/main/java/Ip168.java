import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by cloudchen on 2017-10-07.
 */
public class Ip168 {
    public static By inputtext=By.xpath(".//*[@id='mobile']");
    public static By inputbutton=By.cssSelector(".ButtonStyle");
    public static By phonelocation=By.xpath("//tr[3]/td[2]");
    public static WebDriver driver;
    public Ip168(WebDriver driver)
    {
        this.driver=driver;
    }
    public static String searchphone(String searchstring)
    {
        driver.navigate().to("http://www.ip138.com/sj/");
        driver.findElement(inputtext).sendKeys(searchstring);
        driver.findElement(inputbutton).click();
        Set<String> handles=driver.getWindowHandles();
        String handle=driver.getWindowHandle();
        handles.remove(handle);
        driver.switchTo().window(handles.iterator().next());
        return(driver.findElement(phonelocation).getText());

    }
}
