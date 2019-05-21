package dkc.ThreadImpMethod;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-21
 * Time:19:43
 */
public class TestSecondMethod {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        MyThread1 mt2 = new MyThread1();
        MyThread1 mt3 = new MyThread1();
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
