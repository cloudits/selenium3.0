import java.io.*;

/**
 * Created by cloudchen on 2017-07-10.
 */
public class ImportFromTXT {
    public static String[] ImportTXT(String Dir) throws IOException {
        //String encoding="GBK";
        String encoding="UTF-8";
        File FileDir=new File(Dir);
        BufferedReader BufferReader = new BufferedReader( //以缓冲方式读取文本，方便使用readLine读取分行文本
                new InputStreamReader( //将字节转换为字符并指定编码方式
                        new FileInputStream(FileDir),encoding)); //以字节流方式从目录路径读取文件
        String word;
        StringBuffer words = new StringBuffer();

        //分行读取缓冲区中文本，以字符串格式读取至字符序列
        while ((word = BufferReader.readLine()) != null) {
            words.append(word);
        }

        String wordss = words.substring(0); //从序列中从第一个开始读取字符串，0表示开始的第一个字符
        String w[] = wordss.split(","); //按英文逗号分割，并将数据取出存放至一维数组中

        return w;
    }

}
