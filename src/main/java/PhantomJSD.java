import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by cloudchen on 2017-10-26.
 */
public class PhantomJSD {
    public static void phantomjs()
    {
        System.setProperty("phantomjs.binary.path", "phantomjs.exe");
        WebDriver pdriver = new PhantomJSDriver();
        pdriver.get("http://www.baidu.com");
        System.out.println(pdriver.getTitle());
    }

    public static void main(String[] args) {
        phantomjs();
    }
}
