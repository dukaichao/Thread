package dkc.dkc_listen_zx_cp;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-07
 * Time:9:45
 */
public class ProducerConsumerManager {
    private final Queue<Goods> queue  = new LinkedList<>();
    private  final Properties properties;
    private final Integer maxGoods ;
    private final Integer producerNumber;
    private final Long producerSpeed ;
    private final Integer consumerNumber;
    private final Long consumerSpeed;
    private final Producer producer;
    private final Consumers consumers;
    public  ProducerConsumerManager(Properties properties){
        this.properties = properties;
        maxGoods = Integer.parseInt(properties.getProperty("collect.max_capacity"));
        producerNumber = Integer.parseInt(properties.getProperty("producer.number"));
        producerSpeed = Long.parseLong(properties.getProperty("producer.speed"));
        consumerNumber = Integer.parseInt(properties.getProperty("consumer.number"));
        consumerSpeed = Long.parseLong(properties.getProperty("consumer.speed"));
        producer = new Producer(queue,maxGoods,producerSpeed);
        consumers = new Consumers(queue,consumerSpeed);

    }
    public void startProducer(){
        for(int i = 0;i<producerNumber;i++){
            new Thread(producer,"生产者——"+i).start();
        }
    }

    public void startConsumer(){
        for(int i = 0;i<consumerNumber;i++){
            new Thread(consumers,"消费者——"+i).start();
        }
    }


}
