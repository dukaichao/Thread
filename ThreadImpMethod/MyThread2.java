package dkc.ThreadImpMethod;

import java.util.concurrent.Callable;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-21
 * Time:19:48
 */
public class MyThread2 implements Callable<String> {
    private int t = 20;
    @Override
    public String call() throws Exception {
        while(t>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程为:"+Thread.currentThread().getName()+"剩余票数为："+t--);
        }
        return "买完了  下次来吧";
    }
}
