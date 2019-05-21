package dkc.ThreadImpMethod;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-21
 * Time:19:31
 */
public class TestFirstMethod {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread th1 = new Thread(mt);
        Thread th2 = new Thread(mt);
        Thread th3 = new Thread(mt);
        th1.start();
        th2.start();
        th3.start();
    }
}
