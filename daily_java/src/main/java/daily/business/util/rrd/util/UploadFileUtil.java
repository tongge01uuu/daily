package daily.business.util.rrd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 上传下载读取文件工具类
 * @author luzongwei
 */
public class UploadFileUtil {

    public static void main(String[] args) {
        Collection<String> keys = new LinkedHashSet();
        File importFile = new File("D:/temp/duplicate.txt");
        Object[] result = UploadFileUtil.getFileData(importFile, keys);
        keys = (Collection<String>) result[0];
        System.out.println(StringUtil.print(keys));
        System.out.println(result[1]);
    }

    public static String renameFile(String filePath) {
        int i = filePath.lastIndexOf(".");
        return UUID.randomUUID() + filePath.substring(i);
    }

    /**
     * 读取流内已空格或者回车分隔的数据(数据为userId或手机号)
     *
     * @param inputStream
     * @return {Collection<String>, msg}
     */
    public static Object[] getFileData(File file, Collection<String> collection) {
        if (file == null) {
            return null;
        }
        Map<String, Integer> duplicateValue = new HashMap();
        BufferedReader reader = null;
        String tempString = null;
        try {
            FileInputStream in = new FileInputStream(file);
            String dc = Charset.defaultCharset().name();
            UnicodeInputStream uin = new UnicodeInputStream(in, dc);
            reader = new BufferedReader(new UnicodeReader(uin, null));
            while ((tempString = reader.readLine()) != null) {
                String[] stringArr = tempString.split(" ");
                for (String string : stringArr) {
                    string = string.trim();
                    if (string != null && !"".equals(string)) {
                        if (!collection.add(string)) {
                            duplicateValue.put(string, duplicateValue.get(string) != null ? duplicateValue.get(string) + 1 : 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new Object[]{collection, duplicateValue.size() > 0 ? duplicateValue : null};
    }

}
