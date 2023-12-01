package com.admin.app.kafka.producer.impl;

import com.admin.app.kafka.producer.PromotionKafkaProducer;
import com.admin.core.data.Void;
import kafka.models.base.OperationType;
import kafka.models.promotion.PromotionKafkaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PromotionKafkaProducerImpl implements PromotionKafkaProducer {


    private final KafkaTemplate<String, PromotionKafkaModel> promotionKafkaModelKafkaTemplate;

    private void send(final PromotionKafkaModel promotionKafkaModel) {
        promotionKafkaModelKafkaTemplate.send("promotions", promotionKafkaModel.getId().toString(), promotionKafkaModel);
    }
    
    @Override
    public Void add(final PromotionKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.ADD_EDITE);
        return Void.exec(this::send, kafkaModel);
    }

    @Override
    public Void delete(final PromotionKafkaModel kafkaModel) {
        kafkaModel.setOperationType(OperationType.DELETE);
        return Void.exec(this::send, kafkaModel);
    }
}
