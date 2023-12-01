package com.admin.app.kafka.producer.impl;

import com.admin.app.kafka.producer.GoodBrandKafkaProducer;
import com.admin.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodBrandKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodBrandKafkaProducerImpl implements GoodBrandKafkaProducer {


    private final KafkaTemplate<String, GoodBrandKafkaModel> goodBrandKafkaModelKafkaTemplate;

    private void send(final GoodBrandKafkaModel kafkaModel) {
        goodBrandKafkaModelKafkaTemplate.send("goodsBrands", kafkaModel.getId().toString(), kafkaModel);
    }
    @Override
    public Void add(final GoodBrandKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, kafkaModel);
    }

    @Override
    public Void delete(final GoodBrandKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, kafkaModel);
    }
}
