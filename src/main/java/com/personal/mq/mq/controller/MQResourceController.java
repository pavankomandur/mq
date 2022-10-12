package com.personal.mq.mq.controller;

import com.personal.mq.mq.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class MQResourceController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @RequestMapping(value = "/storeInfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String putMessageInMQ(@RequestBody Employee employee)
    {
        jmsTemplate.convertAndSend("DEV.QUEUE.1", employee);
        System.out.println("Successfully Sent to the Queue #################");
        return "Success";
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessageInMQ()
    {
       Employee employee=(Employee) jmsTemplate.receiveAndConvert("DEV.QUEUE.1");
        System.out.println("Successfully got from the Queue #################" + employee.toString());
        return "Success";
    }

}
