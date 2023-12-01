package com.configuration.app.kafka.producer.impl;

import com.configuration.app.kafka.producer.MenuKafkaProducer;
import com.configuration.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.menu.MenuKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuKafkaProducerImpl implements MenuKafkaProducer {

    private final KafkaTemplate<String, MenuKafkaModel> menuKafkaModelKafkaTemplate;

    private void send(final MenuKafkaModel goodsKafkaModel) {
        menuKafkaModelKafkaTemplate.send("menu", goodsKafkaModel.getId().toString(), goodsKafkaModel);
    }

    @Override
    public Void add(final MenuKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, kafkaModel);
    }

    @Override
    public Void delete(final MenuKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, kafkaModel);
    }
}
