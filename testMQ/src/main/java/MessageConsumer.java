import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 启动同一个main多次的方法：
 * 先启动一个之后，在右上角配置启动项的地方点击配置，然后选择allow running in parallel
 */
public class MessageConsumer {
    //定义ActiveMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "MyMessage";

    public static void main(String[] args) throws JMSException{
        //创建工程连接
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建消费者
        javax.jms.MessageConsumer consumer = session.createConsumer(destination);
        //创建消费的监听
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
