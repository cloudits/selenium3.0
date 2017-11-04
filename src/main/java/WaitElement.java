import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by cloudchen on 2017-11-04.
 */
public class WaitElement {
    public static void main(String[] args) throws Exception {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        WebElement e;
        /*
        e=driver.findElement(By.id("id"));
        System.out.println("timeout");
        e = (new WebDriverWait( driver, 10)) .until(
              new ExpectedCondition< WebElement>(){
	        @Override
            public WebElement apply( WebDriver d) {
                            return d.findElement( By.id("id locator"));
                       }
	    }
        );
        System.out.println("wait10");
        */
        e=new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("id")));
        System.out.println("10 s");
    }
}