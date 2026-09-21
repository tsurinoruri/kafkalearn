package com.example.order_service;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import tools.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    //используется для создания продюсеров
    @Bean
    public ProducerFactory<String, Order> producerFactory(ObjectMapper objectMapper){
        Map<String, Object> configProperties = new HashMap<>();
        //указываются адреса
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9082");

        JsonSerializer<Order> serializer = new JsonSerializer<>(objectMapper);
        serializer.setAddTypeInfo(false);

        //два сериалайзера потому что пишем
        //ключ и значение
        //ключ строка или число - значение событие
        //другие сервисы читают Json и подставляют в свои методы нужные данные с заказа
        return new DefaultKafkaProducerFactory<>(
                configProperties,
                new StringSerializer(),
                serializer
        );
    }

    //класс для операций
    @Bean
    public KafkaTemplate<String, Order> kafkaTemplate(
            ProducerFactory<String, Order> producerFactory
    ){
        return new KafkaTemplate<>(producerFactory);
    }
}
