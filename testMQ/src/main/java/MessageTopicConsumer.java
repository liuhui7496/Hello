import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.jms.MessageConsumer;

public class MessageTopicConsumer {
    //定义ActiveMq的连接地址
    private static final String ACTIVE_URL = "tcp://127.0.0.1:61616";
    //定义发送消息的主题名称
    private static final String TOPIC_NAME = "MyTopicMessage";

    public static void main(String[] args) throws JMSException{
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try{
                    System.out.println("获取消息：" + textMessage.getText());
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
