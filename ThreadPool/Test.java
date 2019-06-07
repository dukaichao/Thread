package dkc.ThreadPool;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-07
 * Time:19:07
 */
class Callables implements Callable<String>{

    int count = 120;

    @Override
    public String call() throws Exception {
        if(count>0){
            System.out.println(Thread.currentThread().getName()+"还剩余"+--count+"票");
        }
        return Thread.currentThread().getName()+"卖完了";
    }
}
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,3,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2)
                );
        Callables callables = new Callables();
        for(int i = 0;i<5;i++){
            executorService.submit(callables);
        }
        executorService.shutdown();
    }
}
