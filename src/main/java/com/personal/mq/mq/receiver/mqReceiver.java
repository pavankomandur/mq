package com.personal.mq.mq.receiver;


import com.personal.mq.mq.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Component;

@Component
public class mqReceiver {

    @JmsListener(destination = "DEV.QUEUE.1")
    public void getMessageFromMQ(Message<Employee> message)
    {
        System.out.println("Message Received :   " + message.getPayload().toString());
    }

}
