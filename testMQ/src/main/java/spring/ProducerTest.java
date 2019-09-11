package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("producer.xml");
        ProduceService bean = classPathXmlApplicationContext.getBean(ProduceService.class);
        //进行消息发送
        for (int i = 0; i < 100; i++) {
            bean.sendMessage("test"+i);
        }

        classPathXmlApplicationContext.close();
    }
}
