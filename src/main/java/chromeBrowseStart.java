


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by cloudchen on 2017-02-18.
 */
public class chromeBrowseStart {
    private static final Logger logger = LogManager.getLogger(ResolverUtil.Test.class.getName());
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
        logger.info("info message");
        logger.trace("trace message");
        logger.error("error message");
        logger.debug("debug message");

    }
}
