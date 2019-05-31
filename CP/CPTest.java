package dkc.CP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-31
 * Time:21:15
 */
class Goods{
    private String name;
    private int count = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void set() throws InterruptedException {
        synchronized (this){
            if(count == 1){
                System.out.println("请先出售完毕再说");
                this.wait();
            }
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+this);
            this.notify();
        }
    }

    public void get() throws InterruptedException {
        synchronized (this){
            if(count == 0){
                System.out.println("卖完了，等待商品上架");
                this.wait();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+this);
            this.notify();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
class Produce implements Runnable{

    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.set();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CPTest {
    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setName("iPhone 13X");
        Produce produce = new Produce(goods);
        Consumer consumer = new Consumer(goods);
        Thread pt = new Thread(produce,"生产者");
        Thread ct = new Thread(consumer,"消费者");
        ct.start();
        pt.start();


    }


}
