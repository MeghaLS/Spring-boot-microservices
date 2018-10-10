package com.example.jmsreceiver;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class JmsreceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsreceiverApplication.class, args);
    }
    @Bean
    public JmsListenerContainerFactory<?> stockFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public ConnectionFactory hitbtcExchangeJmsConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://172.28.89.53:61617");
    }

    @Bean
    public JmsTemplate hitBtcJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(hitbtcExchangeJmsConnectionFactory());
        return jmsTemplate;
    }
}
