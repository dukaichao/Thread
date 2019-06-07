package dkc.dkc_listen_zx_cp;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-06-06
 * Time:19:09
 */
public class Test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try(InputStream in = Test.class.getClassLoader().
                getResourceAsStream("producer_consumer_init.properties")){
            properties.load(in);
        }catch(IOException e){
            e.printStackTrace();
        }
        ProducerConsumerManager producerConsumerManager = new ProducerConsumerManager(properties);
        producerConsumerManager.startProducer();
        producerConsumerManager.startConsumer();

    }
}
