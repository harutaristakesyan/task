package com.admin.app.kafka.producer.impl;

import com.admin.app.kafka.producer.GoodCategoryKafkaProducer;
import com.admin.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodCategoryKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GoodCategoryKafkaProducerImpl implements GoodCategoryKafkaProducer {

    private final KafkaTemplate<String, GoodCategoryKafkaModel> goodCategoryKafkaModelKafkaTemplate;

    private void send(final GoodCategoryKafkaModel goodsKafkaModel) {
        goodCategoryKafkaModelKafkaTemplate.send("goodsCategories", goodsKafkaModel.getId().toString(), goodsKafkaModel);
    }

    @Override
    public Void add(final GoodCategoryKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, kafkaModel);
    }

    @Override
    public Void delete(final GoodCategoryKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, kafkaModel);
    }
}
