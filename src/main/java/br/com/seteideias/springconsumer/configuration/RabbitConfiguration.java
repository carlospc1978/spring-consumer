package br.com.seteideias.springconsumer.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter conversorDeMensagensJson() {
        Jackson2JsonMessageConverter conversor = new Jackson2JsonMessageConverter();
        return conversor;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory factory (ConnectionFactory connectionFactory,
                                                         SimpleRabbitListenerContainerFactoryConfigurer configurer){

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        factory.setMessageConverter(conversorDeMensagensJson());
        return factory;

    }

}
