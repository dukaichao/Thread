package dkc.dkc_listen_zx_cp;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 生产者
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-06
 * Time:19:08
 */
public class Producer implements  Runnable{

    //容器(队列表示)
    private final Queue<Goods> goodsQueue;
    //容器的最大容量
    private final Integer maxCapacity;

    //生产速率
    private final Long speed;

    private final AtomicInteger goodsId = new AtomicInteger(0);

    public Producer(Queue<Goods> goodsQueue, Integer maxCapacity, Long speed) {
        this.goodsQueue = goodsQueue;
        this.maxCapacity = maxCapacity;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQueue){
                if(this.goodsQueue.size()>=maxCapacity){
                    System.out.println(Thread.currentThread().getName()+"放不下了，卖一点再生产..."+this.goodsQueue.size());
                    try {
                        this.goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    Goods goods = new Goods("商品"+goodsId.getAndDecrement(),Math.random()*100);
                    this.goodsQueue.add(goods);
                    System.out.println(Thread.currentThread().getName()+"可以放下了，继续生产..."+this.goodsQueue.size());
                }
            }
        }
    }
}
