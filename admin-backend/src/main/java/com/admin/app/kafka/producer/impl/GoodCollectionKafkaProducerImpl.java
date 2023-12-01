package com.admin.app.kafka.producer.impl;

import com.admin.app.kafka.producer.GoodCollectionKafkaProducer;
import com.admin.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodCollectionKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodCollectionKafkaProducerImpl implements GoodCollectionKafkaProducer {

    private final KafkaTemplate<String, GoodCollectionKafkaModel> goodCollectionKafkaModelKafkaTemplate;


    private void send(final GoodCollectionKafkaModel goodsKafkaModel) {
        goodCollectionKafkaModelKafkaTemplate.send("goodsCollection", goodsKafkaModel.getId().toString(), goodsKafkaModel);
    }

    @Override
    public Void add(final GoodCollectionKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, kafkaModel);
    }

    @Override
    public Void delete(final GoodCollectionKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, kafkaModel);
    }
}
