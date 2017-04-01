package daily.jave.se.thread.fork;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yukai on 2016/9/12.
 *
 * RecursiveAction：用于没有返回结果的任务。
 * RecursiveTask ：用于有返回结果的任务。
 *
 *
 * Fork/Join使用两个类来完成以上两件事情：
 *
 * ForkJoinTask：
 *    我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。它提供在任务中执行fork()和join()操作的机制，
 *    通常情况下我们不需要直接继承ForkJoinTask类，而只需要继承它的子类，
 *    Fork/Join框架提供了以下两个子类：
 *        RecursiveAction：用于没有返回结果的任务。
 *        RecursiveTask ：用于有返回结果的任务。
 * ForkJoinPool ：
 *    ForkJoinTask需要通过ForkJoinPool来执行，
 *    任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。
 *    当一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任务。
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
        /*
        传统计算
         */
        Long beginTime= System.currentTimeMillis();
        Integer common=new CalculatorFork(0,1000001).commonCompute();
        Long endTime=System.currentTimeMillis();
        System.out.println("common interval:"+(endTime-beginTime));
        System.out.println(common);

        /*
        fork/join 计算
         */
        ForkJoinPool forkJoinPool=new ForkJoinPool();
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
