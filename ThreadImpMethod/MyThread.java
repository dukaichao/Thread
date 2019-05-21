package dkc.ThreadImpMethod;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-21
 * Time:19:24
 */
public class MyThread implements Runnable {
    private int t = 20;

    @Override
    public void run() {
        while(t>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程为:"+Thread.currentThread().getName()+"剩余票数为："+t--);
        }
    }
}
