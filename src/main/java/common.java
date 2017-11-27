import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cloudchen on 2017-11-27.
 */
public class common {
    public static String gettime()
    {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(dateFormat.format(now));
        return (dateFormat.format(now));
    }
    public static void scrshot(WebDriver driver)
    {
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile,new File("D:/"+gettime()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
