import com.sun.java.browser.net.ProxyService;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by cloudchen on 2017-11-29.
 */
public class chromegethar {
    public static void main(String[] args) {

        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
      //  WebDriver driver = new FirefoxDriver(capabilities);
        WebDriver driver=new ChromeDriver(capabilities);
        proxy.newHar("http://testops.ke.qq.com");
        driver.get("http://testops.ke.qq.com");
        Har har = proxy.getHar();
        try {
            har.writeTo(new File("testops.ke.qq.com.har"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
