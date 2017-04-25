package daily.business.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yukai on 2017/4/25.
 */
public class SerialNumberGenerator {
    public static void main(String[] args) {
        SerialNumber serialNumber=SerialNumber.newInstance("55",new Date());
        System.out.println(serialNumber.toString());
        System.out.println(SerialNumber.generatorSerialNumber("55",new Date()));
    }
}

class SerialNumber {

    private static final int MAX_VALUE=9999;
    private static final String FORMAT = "yyMMddHHmmss";
    private static final Format DF= new SimpleDateFormat(FORMAT);
    private static final byte[] lock = new byte[0];
    private String prefix = null;
    private Date date = null;
    private int number=1;
    private static int numberNo=1;
    private static Map<String, SerialNumber> serialNumberObjectMap = new HashMap<String, SerialNumber>();
    private static Map<String, String> serialNumberStringMap = new HashMap<String, String>();

    private SerialNumber(String prefix,Date date){
        this.prefix = prefix;
        this.date = date;
    }

    public static SerialNumber newInstance(String prefix){
        Date date = new Date();
        return newInstance(prefix,date);
    }

    public static SerialNumber newInstance(String prefix,Date date){
        SerialNumber serialNumber = null;
        synchronized (lock) {
            String key = getKey(prefix, date);
            if(serialNumberObjectMap.containsKey(key)){
                serialNumber = serialNumberObjectMap.get(key);
                int number = serialNumber.getNumber();
                if(number<MAX_VALUE){
                    serialNumber.setNumber(number+1);
                }else {
                    serialNumber.setNumber(1);
                }

            } else {
                serialNumber = new SerialNumber(prefix,date);
                serialNumberObjectMap.put(key, serialNumber);
            }
        }
        return serialNumber;
    }

    public static String generatorSerialNumber(String prefix,Date date)
    {
        String serialNumber=null;
        synchronized (SerialNumber.class)
        {
            String key = getKey(prefix, date);
            serialNumber=prefix+ format(date);
            if (serialNumberStringMap.containsKey(key))
            {
                if (numberNo<MAX_VALUE)
                {
                    numberNo++;
                    serialNumber+=String.format("%04d", numberNo);
                }else
                {
                    throw new RuntimeException();
                }
            }else
            {
                serialNumber+=String.format("%04d", numberNo);
            }
            serialNumberStringMap.put(key,serialNumber);
        }
        return serialNumber;
    }



    private static String getKey(String prefix,Date date){
        return prefix+format(date);
    }

    private static String format(Date date){
        return DF.format(date);
    }

    public String toString(){
        return  prefix+ format(date) + String.format("%04d", number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
