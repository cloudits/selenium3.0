import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by cloudchen on 2017-11-07.
 */
public class RemoteDw {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities chromedc=DesiredCapabilities.chrome();
        WebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),chromedc);
        driver.get("http://www.baidu.com");
    }
}
