package daily.jave.se.thread.fork;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yukai on 2016/9/12.
 */
public class CalculatorFork extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 100;
    private int start;
    private int end;
    static int count=0;
    public CalculatorFork(int start, int end) {
        this.start = start;
        this.end = end;
//        模拟异常FutureTask捕获
//        if (count++>5)
//            throw new RuntimeException();
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-start <THRESHOLD){
            for(int i = start; i<= end;i++){
                sum += i;
            }
        }else{
            int middle = (start + end) /2;
            CalculatorFork left = new CalculatorFork(start, middle);
            CalculatorFork right = new CalculatorFork(middle + 1, end);
            ForkJoinTask leftTask=left.fork();
//            logException(leftTask);
            ForkJoinTask rightTask=right.fork();
            sum = left.join() + right.join();
        }
        return sum;
    }

    public void logException(ForkJoinTask task)
    {
        if (!task.isCompletedNormally())
        {
            //futureTask没有正常完成 捕获异常信息
            System.out.println(String.format("Task :%s throw Exception:%s",task,task.getException()));
        }
    }
    public Integer commonCompute(){
        int sum = 0;
        for(int i = start; i<= end;i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        Long beginTime= System.currentTimeMillis();
        Integer common=new CalculatorFork(0,1000001).commonCompute();
        Long endTime=System.currentTimeMillis();
        System.out.println("common interval:"+(endTime-beginTime));
        System.out.println(common);

        beginTime= System.currentTimeMillis();
        Future<Integer> result=forkJoinPool.submit(new CalculatorFork(0,1000001));
        endTime=System.currentTimeMillis();
        System.out.println("fork interval:"+(endTime-beginTime));
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
