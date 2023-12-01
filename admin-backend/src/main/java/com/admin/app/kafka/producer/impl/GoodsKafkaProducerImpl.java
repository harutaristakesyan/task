package com.admin.app.kafka.producer.impl;

import com.admin.app.kafka.producer.GoodsKafkaProducer;
import com.admin.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.goods.GoodsKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsKafkaProducerImpl implements GoodsKafkaProducer {

    private final KafkaTemplate<String, GoodsKafkaModel> goodsKafkaModelKafkaTemplate;

    private void send(final GoodsKafkaModel goodsKafkaModel) {
        goodsKafkaModelKafkaTemplate.send("goods", goodsKafkaModel.getId().toString(), goodsKafkaModel);
    }

    @Override
    public Void add(final GoodsKafkaModel goodsKafkaModel) {
        goodsKafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, goodsKafkaModel);
    }

    @Override
    public Void delete(final GoodsKafkaModel goodsKafkaModel) {
        goodsKafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, goodsKafkaModel);
    }
}
