import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by cloudchen on 2017-05-05.
 */
public class objSelect {
    static WebDriver driver;
    public static void objSelect()
    {
        driver.get("http://localhost/selenium3/xpath1.html");
        WebElement element;
        element=driver.findElement(By.xpath("/html/body/div/a"));//访问超链接
        String linktext=element.getText();//获取对象的text信息
        System.out.print(linktext);//输入text内容
    }
    public static void objsSelect()
    {
        driver.get("http://localhost/selenium3/xpath1.html");
        List<WebElement> elements;
        WebElement element;
        elements=driver.findElements(By.xpath("//div/div"));//获取两个div标签

        int listsize=elements.size();//获取List大小
        System.out.println(listsize);
        for(int i=0;i<=listsize;i++) {//遍历List元素
            element = elements.get(i);//指定list元素下标
            String linktext = element.getText();//获取该元素的文本
            System.out.print(linktext);
        }
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox51\\firefox.exe");
        driver=new FirefoxDriver();
        //objSelect.objSelect();
        //driver.findElement(By.xpath("/html/body/div/a")).click();
        objSelect.objsSelect();
    }

}
