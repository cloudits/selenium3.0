import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-07-01.
 */
public class assertBasic {
    /*
    public static void main(String[] args) {
        String result;
        result="执行成功";
        if(result=="执行成功")
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }
    */
    @Test
    public void testcase1()
    {
        String result;
        result="执行成功";
        Assert.assertEquals(result,"执行成功1","断言返回字符串是否为执行成功");
    }
    @Test
    public void testcase2()
    {
        String result;
        result="执行成功";
        Assert.assertEquals(result,"执行成功","断言返回字符串是否为执行成功");
    }

    @BeforeMethod
    public void setUp() throws Exception {

        System.out.println("@BeforeMethod");
    }
}
