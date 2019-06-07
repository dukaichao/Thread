package dkc.dkc_listen_zx_cp;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-06
 * Time:19:09
 */
public class Consumers implements  Runnable{
    //容器(队列表示)
    private final Queue<Goods> goodsQueue;
    //生产速率
    private final Long speed;

    public Consumers(Queue<Goods> goodsQueue, Long speed) {
        this.goodsQueue = goodsQueue;
        this.speed = speed;
    }

    private final AtomicInteger goodsId = new AtomicInteger(0);

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQueue){
                if(this.goodsQueue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"没商品可卖了，通知店家继续生产"+this.goodsQueue.size());
                    this.goodsQueue.notifyAll();
                }else{
                    Goods goods = this.goodsQueue.poll();
                    if(goods != null){
                        System.out.println(Thread.currentThread().getName()+"买了一个商品，非常高兴..."+this.goodsQueue.size());
                    }
                }
            }
        }
    }
}
