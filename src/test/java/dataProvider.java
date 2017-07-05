import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-07-05.
 */
public class dataProvider {
    @DataProvider(name = "myData")
    public Object[][] Userinfo() {
        return new Object[][]{{"1"},{"2"}};
    }
    @Test(dataProvider="myData")
    public void mycase1(String x)
    {
        System.out.println(x);
    }

}
