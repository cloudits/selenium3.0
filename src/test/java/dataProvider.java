import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

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

    @Test(dataProvider = "ExcelData")
    //有几列写几个形参即可
    public void mycase2(String x,String y,String z)
    {
        System.out.println(x+y+z);
    }

    @Test(dataProvider = "TXTData")//由于数据源没有说明名称，所以这里使用方法名
    public void TXTTest(String data) throws IOException {

        System.out.println("Data is:"+data);
        //Assert.assertTrue(data.contains("Test"));
    }
    @DataProvider
    public Object[][] ExcelData()
    {
        ExcelReader excelReader = new ExcelReaderImpl();
        String excelUrl = "D:/ExcelReadTest.xlsx";

        String[][] excelArray = excelReader.readExcel(excelUrl);
        return excelArray;
    }

    @DataProvider
    public Object[][] TXTData() throws IOException
        {
            //设置需要导入的txt文件路径，并调用txt转化为以为数组功能
            File directory = new File("");//设定为当前文件夹
            String basedir=directory.getCanonicalPath();//获取标准的路径C:\Users\cloudchen\IdeaProjects\selenium3
            String Dir = basedir+"\\src\\main\\files\\TXTData.txt";
            ImportFromTXT txt = new ImportFromTXT();
            String[] arr=txt.ImportTXT(Dir);

            Object[][] data=new Object[arr.length][];//Object第一个下标标记测试方法要调用的次数，所以数据为arr数组的长度

            for(int i=0;i<data.length;i++){
                data[i]=new Object[]{arr[i]};//第二个下标为数据主体部分，需要完全与测试方法中的参数类型和个数相匹配，这里内容为请求的接口地址+arr数组中的每一个数据内容
            }
            return data;
        }
    }
