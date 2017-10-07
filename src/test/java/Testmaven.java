import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by cloudchen on 2017-09-14.
 */
public class Testmaven {
    @Test
    public void test1()
    {
        System.out.println("test");
        Reporter.log("TestOps");
    }
}
