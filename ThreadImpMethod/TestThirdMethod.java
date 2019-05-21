package dkc.ThreadImpMethod;

import FirstThread.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-21
 * Time:19:49
 */
public class TestThirdMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread2 mt = new MyThread2();
        FutureTask<String> task1 = new FutureTask<>(mt);
        FutureTask<String> task2 = new FutureTask<>(mt);
        FutureTask<String> task3 = new FutureTask<>(mt);
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        System.out.println(task2.get());
    }
}
