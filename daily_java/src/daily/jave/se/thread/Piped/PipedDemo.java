package daily.jave.se.thread.Piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yukai on 2017/3/9.
 */
public class PipedDemo {
    public static void main(String[] args) throws Exception{
        final PipedReader reader=new PipedReader();
        PipedWriter writer=new PipedWriter();

        //启动读管道线程
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
           @Override
           public void run() {
               try {
                   print(reader);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
        });

        //写管道线程
        try {
            writer.connect(reader);
            int receive=0;
            while ((receive=System.in.read())>1)
            {
                writer.write(receive);
            }
        } finally {
            writer.close();

//            executorService.shutdownNow();
//            System.exit(-1);
        }

    }

    static public void print(PipedReader reader) throws Exception
    {
        int receive=0;
        try {
            while ((receive=reader.read())>1)
            {
                System.out.print((char)receive);
            }
        } finally {
            reader.close();
        }
    }
}
